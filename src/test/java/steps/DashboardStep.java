package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;

public class DashboardStep extends BaseStep {

    DashboardPage dashboardPage;

    public DashboardStep(WebDriver driver) {
        super(driver);

        dashboardPage = new DashboardPage(driver);
    }

    public void dialogBox(){
        dashboardPage.projectButton.click();
        dashboardPage.deleteButton.click();
    }
}
