package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddProjectPage extends BasePage {
    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "announcement")
    public WebElement announcement;

    @FindBy(id = "show_announcement")
    public WebElement showAnon;

    @FindAll({
            @FindBy(id = "suite_mode_single"),
            @FindBy(id = "suite_mode_single_baseline"),
            @FindBy(id = "suite_mode_multi")
    })
    public List<WebElement> types;

    @FindBy(id = "accept")
    public WebElement addButton;

    @FindBy(xpath = "//div[@class='message message-error']")
    public WebElement errorField;

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }
}