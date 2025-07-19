import api.User;
import api.UserSteps;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pajeobjects.LoginPage;
import pajeobjects.MainPage;
import pajeobjects.PersonalAccountPage;

public class PersonalAccountPageTest  extends BasicSettings {
    private User user;

    @BeforeEach
    @DisplayName("Создаем перед тестом клиента")
    void createAndLoginUser() {
        this.user = User.randomUser();
        UserSteps userSteps = new UserSteps();
        userSteps.createNewUser(user);
        //Логиним созданного пользователя
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setValueEmail(user.getEmail());
        loginPage.setValuePassword(user.getPassword());
        loginPage.clickLoginButton();
    }

    @AfterEach
    @Description("Удаляем пользователя после теста")
    void deleteUser(){
        UserSteps userSteps = new UserSteps();
        Response response = userSteps.loginUser(user);
        userSteps.deleteUser(userSteps.getAccessToken(response), user);
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void moveToAccountPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        Assertions.assertTrue(personalAccountPage.isPersonalAccountEnable());
    }

    @Test
    @DisplayName("Проверь переход в конструктор по клику на «Конструктор»")
    public void moveToConstructorByConstructorButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

    @Test
    @DisplayName("Проверь переход в конструктор по клику на на логотип Stellar Burgers")
    public void moveToConstructorByLogoButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();
        Assertions.assertTrue(mainPage.isActivityButtonPlaceAnOrder());
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабине")
    public void logOutFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickExitButton();
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertEquals("Вход",loginPage.getValueHeader());
    }


}