import api.User;
import api.UserSteps;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import pajeobjects.LoginPage;
import pajeobjects.MainPage;
import pajeobjects.RegistrationPage;

public class RegistrationPageTest extends BasicSettings {
    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(4) + ".ru";
    private final String correctPassword = RandomStringUtils.randomAlphabetic(7);
    private final String incorrectPassword = RandomStringUtils.randomAlphabetic(5);


    @Nested //Вложенный класс для удаления пользователя после успешной регистрации
    public class forClearUser {

        @AfterEach
        public void deleteUser() {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(correctPassword);
            UserSteps userSteps = new UserSteps();
            Response response = userSteps.loginUser(user);
            userSteps.deleteUser(userSteps.getAccessToken(response), user);
        }

        @Test
        @DisplayName("Успешная регистрация")
        public void successRegisterTest() {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickRegistrationButton();

            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.registrationUser(name, email, correctPassword);
            Assertions.assertEquals(email, loginPage.getValueEmail());
            Assertions.assertEquals(correctPassword, loginPage.getValuePassword());
        }
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void failedPasswordRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUser(name, email, incorrectPassword);
        Assertions.assertEquals("Некорректный пароль", registrationPage.getTextPasswordIncorrectMessage());
    }
}