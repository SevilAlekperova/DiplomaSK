package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;

public class DashboardStep extends BaseStep {

    private final DashboardPage dashboardPage;

    public DashboardStep(WebDriver driver) {
        super(driver);

        dashboardPage = new DashboardPage(driver);
    }


    public void dash(){
        dashboardPage.clickAdministrationButton();
        dashboardPage.clickProjectButton();
        dashboardPage.clickDeleteButton();
        dashboardPage.clickConfirmDeleteProjectCheckBox();
        dashboardPage.confirmDeleteProjectCheckBox();

    }
}
