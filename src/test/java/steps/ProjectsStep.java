package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;
import pages.projects.ProjectsPage;

public class ProjectsStep extends BaseStep {
    public AddProjectPage addProjectPage;

    public ProjectsStep(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
    }

    public ProjectsPage createProjectSuccessful(Project project) {
        addProjectPage.name.sendKeys(project.getName());
        addProjectPage.announcement.sendKeys(project.getAnnouncement());
        addProjectPage.types.get(project.getType()).click();

        if (project.isShowAnon()) {
            addProjectPage.showAnon.click();

        }

        addProjectPage.addButton.click();

        return new ProjectsPage(driver);
    }

}
