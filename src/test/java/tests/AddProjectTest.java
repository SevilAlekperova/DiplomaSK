package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.projects.ProjectsPage;
import steps.DashboardStep;
import steps.ProjectsStep;

import java.util.ArrayList;
import java.util.List;

public class AddProjectTest extends BaseTest {
    private ProjectsStep addProjectStep;

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
        DashboardPage dashboardPage = new DashboardPage(driver);
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

        projectsPage.add.click();
        Thread.sleep(4000);
    }



    @Test
    public void createProjectFailureTest() {
        Assert.assertTrue(addProjectStep.createProjectIncorrect().errorField.isDisplayed());
    }

    @Test
    public void deleteProjectTest() {
        dashboardStep.dash();
    }
}
