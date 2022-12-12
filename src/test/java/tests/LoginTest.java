package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginStep.login(new User(ReadProperties.username(), ReadProperties.password()));

        Assert.assertTrue(new DashboardPage(driver).isHeaderTitleLabelDisplayed());
    }

    @Test
    public void successLoginTest1() {
        Assert.assertTrue(
                loginStep.loginSuccessful(new User(ReadProperties.username(), ReadProperties.password())).isHeaderTitleLabelDisplayed()
        );
    }

    @Test
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginIncorrect(new User("fgcydfrhy", ReadProperties.password())).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

}