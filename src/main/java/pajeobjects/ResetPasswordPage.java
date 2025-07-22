package pajeobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage (WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    private final By pathLoginButton = By.xpath(".//*/a[text()='Войти']");

    //Методы
    @Step("Нажимаем кнопку Войти на форме восстановления пароля")
    public void clickLoginButton() {
        driver.findElement(pathLoginButton).click();
    }
}