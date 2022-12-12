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

    // Блок инициализации страницы
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов

    public boolean isHeaderTitleLabelDisplayed() { return headerTitleLabel.isDisplayed(); }
}

