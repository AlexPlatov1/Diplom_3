package pajeobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    private final By pathNameInput = By.xpath(".//div[label[.='Имя']]//input[@name='name']");
    private final By pathEmailInput = By.xpath(".//div[label[.='Email']]//input[@name='name']");
    private final By pathPasswordInput = By.xpath(".//div[label[.='Пароль']]//input[@name='Пароль']");
    private final By pathRegistrationButton = By.xpath(".//*/button[text()='Зарегистрироваться']");
    private final By pathIncorrectPasswordMessage = By.xpath(".//*/p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    private final By pathLoginButton = By.xpath(".//*/a[text()='Войти']");

    //Методы
    @Step("Заполняем поле Имя")
    public void setUserName(String name) {
        driver.findElement(pathNameInput).sendKeys(name);
    }

    @Step("Заполняем поле Email")
    public void setUserEmail(String email) {
        driver.findElement(pathEmailInput).sendKeys(email);
    }

    @Step("Заполняем поле Пароль")
    public void setUserPassword (String password) {
        driver.findElement(pathPasswordInput).sendKeys(password);
    }

    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(pathRegistrationButton).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(pathLoginButton).click();
    }

    @Step ("Получаем текстовку сообщения о некорректном пароле")
    public String getTextPasswordIncorrectMessage() {
        return driver.findElement(pathIncorrectPasswordMessage).getText();
    }

    @Step("Регистрация пользователя")
    public void registrationUser(String name, String email, String password) {
        setUserName(name);
        setUserEmail(email);
        setUserPassword(password);
        clickRegistrationButton();
    }
}