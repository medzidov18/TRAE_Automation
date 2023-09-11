package tests.steps.projects;

import lombok.SneakyThrows;
import org.testng.Assert;
import selenium.pageobjects.AddProjectForm;
import selenium.pageobjects.HeaderForm;
import selenium.pageobjects.ProjectsPageObject;

import java.util.Random;

import static dataread.DataRead.testDataUiDTO;

public class AddProjectsTestSteps {
    private final HeaderForm headerForm = new HeaderForm();
    private final ProjectsPageObject projectsPageObject = new ProjectsPageObject();
    private final AddProjectForm addProjectForm = new AddProjectForm();

    private final Random random = new Random();

    @SneakyThrows
    public void goToProjectsPageAndClickOnAdd() {
        headerForm.goToProjects();
        projectsPageObject.clickOnAddNewButton();
    }

    @SneakyThrows
    public Integer insertAllDataToAddProject() {
        Integer randomNumberOfProject = random.nextInt(testDataUiDTO.getMaxIdOfProj()-testDataUiDTO.getMinIdOfProj()) + testDataUiDTO.getMinIdOfProj();
        addProjectForm.inputNumberOfProject(randomNumberOfProject);
        addProjectForm.inputNameOfProduct(testDataUiDTO.getNameOfProduct());
        addProjectForm.inputNameOfClient(testDataUiDTO.getNameOfClient());
        addProjectForm.inputComments(testDataUiDTO.getComment());
        addProjectForm.selectDataAfterMonth();
        addProjectForm.selectRandomStep();
        addProjectForm.clickOnEmptyPlace();

        return randomNumberOfProject;
    }

    public void submitAddingNewProject() {
        addProjectForm.clickOnSubmit();
    }

    public void goToProjects() {
        headerForm.goToProjects();
        headerForm.goToProjects();
    }

    public void assertThatAddProjectFormDisplayed() {
        Assert.assertTrue(addProjectForm.isAddProjectFormDisplayed(), "Project Form is not Displayed");
    }

    public void assertThatDataAdded() {
        Assert.assertTrue(addProjectForm.isNumberOfProjectsValueAdded(), "Number of Project is not filled");
        Assert.assertTrue(addProjectForm.isCommentsInputValueAdded(), "Comments is not filled");
        Assert.assertTrue(addProjectForm.isClientNameValueAdded(), "Client Name is not filled");
        Assert.assertTrue(addProjectForm.isNameOfProductValueAdded(), "Name of Project is not filled");
        Assert.assertTrue(addProjectForm.isDateOfEndValueAdded(), "Date of End is not filled");
        Assert.assertTrue(addProjectForm.isStepsAdded(), "Steps is not filled");
    }

    public void assertThatConfirmationWindowDisplayed(Integer randomProjectNumber) {
        Assert.assertTrue(addProjectForm.isConfirmationWindowDisplayed(randomProjectNumber), "Confirmation Form is not Displayed");
    }

    public void assertThatProjectAdded(Integer randomProjectNumber) {
        Assert.assertTrue(projectsPageObject.findProjectByNumber(randomProjectNumber), "Cant find project");
    }
}
