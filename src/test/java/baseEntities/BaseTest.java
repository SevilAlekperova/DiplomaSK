package baseEntities;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import services.BrowsersService;
import steps.DashboardStep;
import steps.LoginStep;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;

    protected DashboardStep dashboardStep;

    protected DashboardPage dashboardPage;


    @BeforeMethod
    public void setUp() {

        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        dashboardStep = new DashboardStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
