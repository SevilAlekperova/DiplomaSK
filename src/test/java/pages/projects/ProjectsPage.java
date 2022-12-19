package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends BasePage {

    private final static String pagePath = "index.php?/admin/projects/overview";

    @FindBy(className = "page_title")
    public WebElement title;

    @FindBy(xpath = "//tbody/tr[@class!='header']")
    public List<WebElement> projects;

    @FindBy(className = "icon-markdown-image")
    public WebElement uploadFileIcon;
    @FindBy(xpath = "//*[@id='dialog-ident-attachmentNewDialogFile']/following::input[@type='file']")
    public WebElement addImageButton;
    @FindBy(id = "attachmentNewSubmit")
    public WebElement submitAddImage;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }
}

