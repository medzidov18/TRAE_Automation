package tests.maintests.office;

import elements.Button;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.core.BaseTest;
import selenium.pageobjects.ProjectsPageObject;
import tests.steps.AuthSteps;
import tests.steps.projects.AddProjectsTestSteps;

public class simpleTest extends BaseTest {
    private final AuthSteps authSteps = new AuthSteps();
    private final AddProjectsTestSteps addProjectsTestSteps = new AddProjectsTestSteps();
    private final ProjectsPageObject projectsPageObject = new ProjectsPageObject();

    @SneakyThrows
    @Test
    public void test() {
        authSteps.loginAsAdmin();
        addProjectsTestSteps.goToProjects();
        projectsPageObject.goToNextPage();
        Thread.sleep(4000);
    }
}
