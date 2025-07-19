package pajeobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    WebDriver driver;

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    //Локтаоры
    private final By pathToProfileButton = By.xpath(".//*/a[text()='Профиль']");
    private final By pathLogoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By pathExitButton = By.xpath(".//button[text()='Выход']");
    private final By pathConstructorButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href = '/']");
    //Методы
    @Step("Проверяем что появился Профиль")
    public boolean isPersonalAccountEnable() {
        return driver.findElement(pathToProfileButton).isEnabled();
    }

    @Step("Нажимаем кнопку логотипа")
    public void clickLogo() {
        driver.findElement(pathLogoButton).click();
    }

    @Step("Нажимаем кнопку Выход")
    public void clickExitButton() {
        driver.findElement(pathExitButton).click();
    }

    @Step("Нажимаем кнопку Конструктор в хэдере")
    public void clickConstructorButton() {
        driver.findElement(pathConstructorButton).click();
    }
}