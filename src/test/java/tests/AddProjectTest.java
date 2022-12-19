package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.projects.AddProjectPage;
import pages.projects.ProjectsPage;
import steps.ProjectsStep;

public class AddProjectTest extends BaseTest {
    private ProjectsStep addProjectStep;
    DashboardPage dashboardPage = new DashboardPage(driver);


    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();

        loginStep.loginSuccessful(
                new User(ReadProperties.username(), ReadProperties.password())
        );
    }

    @Test
    public void createProjectSuccessTest() {
        dashboardPage.clickAddProjectButton();
        addProjectStep = new ProjectsStep(driver);
        ProjectsPage projectsPage = addProjectStep.createProjectSuccessful(
                new Project.Builder()
                        .nameTest("TestName")
                        .announcement("Test Announcement")
                        .typeOfTest(2)
                        .showAnon(true)
                        .build()
        );

        Assert.assertTrue(projectsPage.title.isDisplayed());
    }

    @Test
    public void maxLengthProjectNameFieldTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.name.sendKeys(RandomStringUtils.randomAlphabetic(251));
    }

    @Test
    public void uploadTest() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        dashboardPage.clickAddTestSuiteButton();
        projectsPage.uploadFileIcon.click();


        WebElement fileUploadPath = projectsPage.addImageButton;
        String pathToFile = this.getClass().getResource("/downloading.jpg").getPath();
        String pathToFileFixed = pathToFile.substring(1);
        System.out.println(pathToFileFixed);
        fileUploadPath.sendKeys(pathToFileFixed);
        Thread.sleep(4000);

        projectsPage.add.click();
    }



    @Test
    public void dialogWindowTest() {
        dashboardStep.dialogWindow();
    }

    @Test
    public void deleteProjectTest() {
        dashboardStep.dialogWindow();
        dashboardStep.deleteProject();
    }
}
