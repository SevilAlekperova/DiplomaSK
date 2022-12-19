package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "index.php?/dashboard";
    private final By headerTitleLabelLocator = By.xpath("//div[contains(text(), 'All Projects')]");

    private final By addProjectButtonLocator = By.id("sidebar-projects-add");
    private final By administrationButtonLocator = By.id("navigation-admin");
    private final By deleteButtonLocator = By.className("icon-small-delete");
    private final By projectButtonLocator = By.id("navigation-sub-projects");
    private final By popUpMessageLocator = By.xpath("//a[@class='link-tooltip']");
    private final By confirmDeleteProjectCheckBoxLocator = By.xpath("//div/div/div/div/div/label/input[contains(@type, 'checkbox')]");
    private final By confirmDeleteProjectButtonLocator = By.xpath("//div/div/div/a[contains(text(), 'OK')]");
    private final By addTestSuiteButtonLocator = By.xpath("//div[contains(@class, 'table summary summary-auto')]/div[1]//a[1][contains(text(), 'test suite')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

    public WebElement getAdministrationButton() {
        return driver.findElement(administrationButtonLocator);
    }

    public WebElement getDeleteButton() {
        return driver.findElement(deleteButtonLocator);
    }

    public WebElement getProjectButton() {
        return driver.findElement(projectButtonLocator);
    }

    public WebElement getConfirmDeleteProjectCheckBox() {
        return driver.findElement(confirmDeleteProjectCheckBoxLocator);
    }

    public WebElement getConfirmDeleteProjectButton() {
        return driver.findElement(confirmDeleteProjectButtonLocator);
    }

    public WebElement getAddTestSuiteButton() {
        return driver.findElement(addTestSuiteButtonLocator);
    }

    public WebElement getPopUpMessage() {
        return driver.findElement(popUpMessageLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public boolean isHeaderTitleLabelDisplayed() {
        return getHeaderTitleLabel().isDisplayed();
    }


    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }

    public void clickAdministrationButton() {
        getAdministrationButton().click();
    }

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    public void clickProjectButton() {
        getProjectButton().click();
    }

    public void confirmDeleteProjectCheckBox() {
        getConfirmDeleteProjectCheckBox().click();
    }

    public void clickConfirmDeleteProjectButton() {
        getConfirmDeleteProjectButton().click();
    }

    public void clickAddTestSuiteButton() {
        getAddTestSuiteButton().click();
    }
}

