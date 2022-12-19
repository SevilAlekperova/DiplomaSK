package tests.UI;

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
    public void popUpMessageTest() {
        loginStep.login(new User(ReadProperties.username(), ReadProperties.password()));
        Assert.assertTrue(new DashboardPage(driver).isHeaderTitleLabelDisplayed());
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(
                dashboardPage.getPopUpMessage().getAttribute("tooltip-text")
                , "Displays the active projects as a compact list. Useful if you have many projects.");
    }


    @Test
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginIncorrect(new User("fgcydfrhy", ReadProperties.password())).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void incorrectUsernameTestWithDefect() {
        Assert.assertEquals(
                loginStep.loginIncorrect(new User("fgcydfrhy", ReadProperties.password())).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.11");
    }

}