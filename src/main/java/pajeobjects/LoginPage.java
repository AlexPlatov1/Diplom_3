package pajeobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage {
    // создание экземпляра WebDriver
    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    private final By pathRegistrationButton = By.xpath(".//*/a[@href='/register' and text()='Зарегистрироваться']");
    private final By pathEmailInput = By.xpath(".//div[label[.='Email']]//input[@name='name']");
    private final By pathPasswordInput = By.xpath(".//div[label[.='Пароль']]//input[@name='Пароль']");
    private final By pathLoginButton = By.xpath(".//*/button[text()='Войти']");
    private final By pathResetPassword = By.xpath(".//*/a[text()='Восстановить пароль']");
    private final By pathToHeaderLogin = By.xpath(".//*/h2[text()='Вход']");


    //Методы
    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(pathRegistrationButton).click();
    }

    @Step("Получаем значение поля Email")
    public String getValueEmail () {
        String email = driver.findElement(pathEmailInput).getAttribute("value");
        return email;
    }

    @Step("Получаем значение поля Пароль")
    public String getValuePassword () {
        String password = driver.findElement(pathPasswordInput).getAttribute("value");
        return password;
    }

    @Step("Вводим Email в форме логина")
    public void setValueEmail (String email) {
        driver.findElement(pathEmailInput).sendKeys(email);
    }

    @Step("Вводим Password в форме логина")
    public void setValuePassword (String password) {
        driver.findElement(pathPasswordInput).sendKeys(password);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton(){
        driver.findElement(pathLoginButton).click();
    }

    @Step("Нажимаем кнопку Восстановить пароль")
    public void clickResetPasswordButton(){
        driver.findElement(pathResetPassword).click();
    }

    @Step("Получаем значение заголовка страницы Вход")
    public String getValueHeader () {
        String header = driver.findElement(pathToHeaderLogin).getText();
        return header;
    }

}