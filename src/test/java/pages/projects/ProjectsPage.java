package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends BasePage {

    private final static String pagePath = "index.php?/admin/projects/overview";

    // Блок описания селекторов для элементов
    @FindBy(className = "page_title")
    public WebElement title;

    @FindBy(xpath = "//tbody/tr[@class!='header']")
    public List<WebElement> projects;

    @FindBy(className = "icon-markdown-image")
    public WebElement uploadFileIcon;

    //@FindBy(id = "libraryAddAttachment")

    //@FindBy(xpath = "//div[contains(@id, 'libraryAttachmentsAddItem')]/div[contains(@class, 'attachment-library-add-icon dz-clickable')]")
    @FindBy(xpath = "//*[@id='libraryAttachmentsAddItem']/div")
    public WebElement addImageButton;
    @FindBy(id = "attachmentNewSubmit")
    public WebElement add;
//        public void addImage(String value) {
//                addImageButton.sendKeys(value);
//        }


    // Блок инициализации страницы
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }
}

