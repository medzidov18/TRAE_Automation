package selenium.core;

import core.ConnectDatabase;
import core.DriverUtility;
import lombok.SneakyThrows;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static dataread.DataRead.configUiDTO;

public abstract class BaseTest {
    @BeforeTest
    public void initializeSqlConnection() {
        ConnectDatabase.initialize();
    }
    @BeforeMethod (alwaysRun = true)
    public void initialize() {
        DriverUtility.Initialize();
        DriverUtility.getDriver().manage().window().maximize();
        DriverUtility.getDriver().manage().timeouts().implicitlyWait(configUiDTO.getImplicitWaitDuration(), TimeUnit.SECONDS);
        DriverUtility.getDriver().get(configUiDTO.getBaseUri());
    }

    @AfterMethod
    public void tearDown() {
        DriverUtility.quitBrowser();
    }

    @AfterTest
    public void closeSqlTest() throws SQLException {
        ConnectDatabase.getConnection().close();
    }
}