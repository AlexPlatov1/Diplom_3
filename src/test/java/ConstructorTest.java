import api.User;
import api.UserSteps;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pajeobjects.LoginPage;
import pajeobjects.MainPage;

public class ConstructorTest extends BasicSettings {
    User user;

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
    @DisplayName("Проверка перехода к разделу Булки")
    public void moveToBunSection() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientMenuFilling();
        mainPage.clickIngredientMenuBun();
        Assertions.assertEquals("Булки",mainPage.sectionSelectedText());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void moveToSauceSection() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientMenuSauce();
        Assertions.assertEquals("Соусы",mainPage.sectionSelectedText());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    public void moveToFillingSection() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientMenuFilling();
        Assertions.assertEquals("Начинки",mainPage.sectionSelectedText());
    }

}