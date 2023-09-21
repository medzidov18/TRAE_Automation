package core;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import core.LoggerUtility;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConditionalWait;

import java.time.Duration;

import static dataread.DataRead.configUiDTO;

public class DriverUtility {
    @Getter
    private static WebDriver driver = null;
    @Getter
    private static ConditionalWait waits = null;
    @Getter
    private static Actions actions = null;
    private static WebStorage storage = null;
    private static JavascriptExecutor executor = null;
    private static LoggerUtility log = new LoggerUtility();
    @Getter
    private static WebDriverWait explicitWait = null;

    private DriverUtility() {
    }

    public static JavascriptExecutor getJavaScriptExecutor() {
        return executor;
    }

    public static void clearLocalStorage() {
        storage.getLocalStorage().clear();
        storage.getSessionStorage().clear();
    }


    public static void Initialize() {
        log.info("Creating Chrome browser...");
        System.setProperty("webdriver.chrome.driver", "/home/elvin/Downloads/chromedriver-linux64/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(configUiDTO.getRemoteAllowGC());

        driver = new ChromeDriver(chromeOptions);
        waits = new ConditionalWait();
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
        storage = (WebStorage) driver;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(configUiDTO.getExplicitWaitDuration()));
    }

    public static void quitBrowser() {
        if (driver != null) {
            log.info("Quitting the browser...");
            getDriver().quit();
        }
        driver = null;
        actions = null;
        storage = null;
        waits = null;
        executor = null;
        explicitWait = null;
    }
}
