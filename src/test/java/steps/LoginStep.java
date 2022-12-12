package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(User user) {
        loginPage.setEmail(user.getLogin());
        loginPage.setPsw(user.getPsw());
        loginPage.clickLoginButton();
    }

    public DashboardPage loginSuccessful(User user) {
        login(user);

        return new DashboardPage(driver);
    }

    public LoginPage loginIncorrect(User user) {
        login(user);

        return loginPage;
    }

    public void logout() {
    }
}
