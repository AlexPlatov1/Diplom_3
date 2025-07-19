package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver driver;
    public static WebDriver getWebDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser","yandex");
            switch (browser) {
                case "chrome":
                    return WebDriverManager.chromedriver().create();
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                    System.setProperty("browserVersion", "134.0");
                    return new ChromeDriver();
                default:
                    throw new RuntimeException("Браузер не установлен:" + browser);
            }
        }
        return driver;
    }
}