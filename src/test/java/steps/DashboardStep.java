package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class DashboardStep extends BaseStep {

    private final DashboardPage dashboardPage;

    public DashboardStep(WebDriver driver) {
        super(driver);

        dashboardPage = new DashboardPage(driver);
    }


    public void dialogWindow(){
        dashboardPage.clickAdministrationButton();
        dashboardPage.clickProjectButton();
        dashboardPage.clickDeleteButton();
        dashboardPage.clickConfirmDeleteProjectButton();
        dashboardPage.confirmDeleteProjectCheckBox();
    }

    public void deleteProject(){
        dashboardPage.clickConfirmDeleteProjectButton();
        dashboardPage.confirmDeleteProjectCheckBox();
    }


}
