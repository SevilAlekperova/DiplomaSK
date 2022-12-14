package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private final static String pagePath = "index.php?/dashboard";

    // Блок описания селекторов для элементов
    @FindBy(xpath = "//div[contains(text(), 'All Projects')]")
    public WebElement headerTitleLabel;

    @FindBy(id = "sidebar-projects-add")
    public WebElement addProjectButton;

    @FindBy(id = "navigation-admin")
    public WebElement administrationButton;

    @FindBy(id = "navigation-sub-projects")
    public WebElement projectButton;

    @FindBy(className = "icon-small-delete")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@class='link-tooltip']")
    public WebElement popUpMessage;

    @FindBy(xpath = "//div/div/div/div/div/label/input")
    public WebElement confirmDeleteProjectCheckBox;

    @FindBy(className = "button button-ok button-left button-positive dialog-action-default button-ok-disabled ")
    public WebElement confirmDeleteProject;

    // Блок инициализации страницы
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement hoverPop() {
        return popUpMessage;
    }



    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов

    public boolean isHeaderTitleLabelDisplayed() { return headerTitleLabel.isDisplayed(); }
}

