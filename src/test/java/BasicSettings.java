import Browser.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pajeobjects.MainPage;

import java.time.Duration;

public class BasicSettings {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = Browser.getWebDriver();
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}