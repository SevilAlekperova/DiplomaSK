package baseEntities;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import services.BrowsersService;
import steps.DashboardStep;
import steps.LoginStep;
import steps.ProjectsStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)


public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;

    protected DashboardStep dashboardStep;

    private ProjectsStep addProjectStep;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {

        driver = new BrowsersService().getDriver();

        iTestContext.setAttribute("driver", driver);

        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        dashboardStep = new DashboardStep(driver);
        addProjectStep = new ProjectsStep(driver);
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
