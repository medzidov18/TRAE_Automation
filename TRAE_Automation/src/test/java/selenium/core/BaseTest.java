package selenium.core;

import Framework.core.DriverUtility;
import lombok.SneakyThrows;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static dataread.DataRead.configUiDTO;

public abstract class BaseTest {
    @BeforeMethod (alwaysRun = true)
    public void initialize() {
        DriverUtility.Initialize();
        DriverUtility.getDriver().manage().window().maximize();
        DriverUtility.getDriver().manage().timeouts().implicitlyWait(configUiDTO.getImplicitWaitDuration(), TimeUnit.SECONDS);
        DriverUtility.getDriver().get(configUiDTO.getBaseUri());
    }

    @AfterMethod
    public void tearDown() {
        DriverUtility.getDriver().quit();
    }
}