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

    public void clickAddProject(){
        dashboardPage.clickAddProjectButton();
    }


    public void dialogWindow(){
        dashboardPage.clickAdministrationButton();
        dashboardPage.clickProjectButton();
        dashboardPage.clickDeleteButton();
    }

    public void deleteProject(){
        dashboardPage.confirmDeleteProjectCheckBox();
        dashboardPage.clickConfirmDeleteProjectButton();
    }


}
