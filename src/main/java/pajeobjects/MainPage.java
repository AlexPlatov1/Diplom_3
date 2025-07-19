package pajeobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // Конструктор класса с драйвером
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    private final By pathLoginButton = By.xpath(".//*/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private final By pathPersonalAccount = By.xpath(".//*/p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private final By pathConstructor = By.xpath(".//*/p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private final By pathIngredientBun = By.xpath(".//*/span[text()='Булки']");
    private final By pathIngredientSauce = By.xpath(".//*/span[text()='Соусы']");
    private final By pathIngredientFilling = By.xpath(".//*/span[text()='Начинки']");
    private final By pathPlaceAnOrder = By.xpath(".//*/button[text()='Оформить заказ']");
    private final By pathSelectedSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");




    @Step("Открываем главную страницу")
    public void mainPageOpen () {
        driver.get(MAIN_PAGE_URL);
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLoginButton (){
        driver.findElement(pathLoginButton).click();
    }

    @Step("Нажимаем на кнопку Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(pathPersonalAccount).click();
    }

    @Step("Нажимаем на раздел с ингридиентами Булки")
    public void clickIngredientMenuBun() {
        driver.findElement(pathIngredientBun).click();
    }

    @Step("Нажимаем на раздел с ингридиентами Соусы")
    public void clickIngredientMenuSauce() {
        driver.findElement(pathIngredientSauce).click();
    }

    @Step("Нажимаем на раздел с ингридиентами Начинки")
    public void clickIngredientMenuFilling() {
        driver.findElement(pathIngredientFilling).click();
    }

    @Step("Проверяем активность кнопки Оформить заказ")
    public boolean isActivityButtonPlaceAnOrder() {
        return driver.findElement(pathPlaceAnOrder).isEnabled();
    }

    @Step("Проверяем текст выбранного раздела")
    public String sectionSelectedText() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(pathSelectedSection).getText();
    }


}