package Framework.core;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import core.LoggerUtility;
import utility.ConditionalWait;

import static dataread.DataRead.configUiDTO;

public class DriverUtility {
    @Getter
    private static WebDriver driver;
    private static ConditionalWait waits;
    private static Actions actions;
    private static WebStorage storage;
    private static JavascriptExecutor executor;
    private static LoggerUtility log = new LoggerUtility();

    private DriverUtility() {
    }

    public static ConditionalWait getWaits() {
        return new ConditionalWait();
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor getJavaScriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void clearLocalStorage() {
        storage = (WebStorage) getDriver();
        storage.getLocalStorage().clear();
        storage.getSessionStorage().clear();
    }


    public static void Initialize() {
        log.info("Creating Chrome browser...");
        System.setProperty("webdriver.chrome.driver", "/home/elvin/Downloads/chromedriver-linux64/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(configUiDTO.getRemoteAllowGC());

        driver = new ChromeDriver(chromeOptions);
    }

    public static void quitBrowser() {
        if (driver != null) {
            log.info("Quitting the browser...");
            getDriver().close();
            getDriver().quit();
        }
        driver = null;
    }
}
