package tests.maintests.projects;

import org.testng.annotations.Test;
import selenium.core.BaseTest;
import tests.steps.AuthSteps;
import tests.steps.projects.AddProjectsTestSteps;

public class AddProjectsTest extends BaseTest {
    private final AuthSteps authSteps = new AuthSteps();
    private final AddProjectsTestSteps addProjectsTestSteps = new AddProjectsTestSteps();

    @Test
    public void addMultipleProjects() {
        authSteps.loginAsAdmin();

        addProjectsTestSteps.goToProjectsPageAndClickOnAdd();
        addProjectsTestSteps.assertThatAddProjectFormDisplayed();

        Integer numberOfProject = addProjectsTestSteps.insertAllDataToAddProject();
        addProjectsTestSteps.assertThatDataAdded();

        addProjectsTestSteps.submitAddingNewProject();
        addProjectsTestSteps.assertThatConfirmationWindowDisplayed(numberOfProject);

        addProjectsTestSteps.goToProjects();
        addProjectsTestSteps.assertThatProjectAdded(numberOfProject);
    }
}
