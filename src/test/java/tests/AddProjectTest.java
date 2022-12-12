package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.projects.ProjectsPage;
import steps.ProjectsStep;

public class AddProjectTest extends BaseTest {
    private ProjectsStep addProjectStep;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();

        loginStep.loginSuccessful(
                new User(ReadProperties.username(), ReadProperties.password())
        ).addProjectButton.click();
        addProjectStep = new ProjectsStep(driver);
    }

    @Test
    public void createProjectSuccessTest() {
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
    public void createProjectFailureTest() {
        Assert.assertTrue(addProjectStep.createProjectIncorrect().errorField.isDisplayed());
    }
}
