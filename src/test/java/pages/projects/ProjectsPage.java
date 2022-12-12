package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends BasePage{

        private final static String pagePath = "index.php?/admin/projects/overview";

        // Блок описания селекторов для элементов
        @FindBy(className = "page_title")
        public WebElement title;

        @FindBy(xpath = "//tbody/tr[@class!='header']")
        public List<WebElement> projects;

        // Блок инициализации страницы
        public ProjectsPage(WebDriver driver) {
            super(driver);
        }
}

