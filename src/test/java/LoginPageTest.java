import api.User;
import api.UserSteps;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pajeobjects.LoginPage;
import pajeobjects.MainPage;
import pajeobjects.RegistrationPage;
import pajeobjects.ResetPasswordPage;

public class LoginPageTest extends BasicSettings {
    private User user;

    @BeforeEach
    @Description("Создаем перед тестом клиента")
    void createUser() {
        this.user = User.randomUser();
        UserSteps userSteps = new UserSteps();
        userSteps.createNewUser(user);
    }

    @AfterEach
    @Description("Удаляем пользователя после теста")
    void deleteUser(){
        UserSteps userSteps = new UserSteps();
        Response response = userSteps.loginUser(user);
        userSteps.deleteUser(userSteps.getAccessToken(response), user);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromLoginButtonMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setValueEmail(user.getEmail());
        loginPage.setValuePassword(user.getPassword());
        loginPage.clickLoginButton();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setValueEmail(user.getEmail());
        loginPage.setValuePassword(user.getPassword());
        loginPage.clickLoginButton();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButton();
        loginPage.setValueEmail(user.getEmail());
        loginPage.setValuePassword(user.getPassword());
        loginPage.clickLoginButton();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromResetPasswordForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickResetPasswordButton();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.clickLoginButton();
        loginPage.setValueEmail(user.getEmail());
        loginPage.setValuePassword(user.getPassword());
        loginPage.clickLoginButton();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

}