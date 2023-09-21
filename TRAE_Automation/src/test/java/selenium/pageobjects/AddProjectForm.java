package selenium.pageobjects;

import base.BaseForm;
import core.DriverUtility;
import elements.*;
import org.openqa.selenium.By;
import utility.RandomUtility;

import java.util.Calendar;

import static dataread.DataRead.configUiDTO;

public class AddProjectForm extends BaseForm {
    private final Label numberOfProjectInput = new Label(By.xpath("//input[@placeholder='Номер проекта' and contains(@class, 'mantine-Input-input')]"), "Project Number");
    private final Label nameOfProductInput = new Label(By.xpath("//input[@placeholder='Наименование изделия' and contains(@class, 'mantine-Input-input')]"), "Name of Product");
    private final Label clientOfProjectInput = new Label(By.xpath("//input[@placeholder='Клиент' and contains(@class, 'mantine-Input-input')]"), "Client");
    private final Label commentsInput = new Label(By.xpath("//textarea[@placeholder='Комментарий' and contains(@class, 'mantine-Input-input')]"), "Comments");

    private final Button dateOfProjectEndingInputEmpty = new Button(By.xpath("//span[text()='Выберите дату' and contains(@class, 'mantine-DatePickerInput-placeholder')] "), "Date of end of the Project Empty");
    private final Button dateOfProjectEndingInputFilled = new Button(By.xpath("//button[contains(@class, 'mantine-DatePickerInput-input') and contains(@class, ' mantine-DatePickerInput-input')]"), "Date of end of the Project Filled");
    private final Button stepsOfProjectInput = new Button(By.xpath("//div[@aria-haspopup='menu']"), "Steps Of Project");
    private final Button submitFormButton = new Button(By.xpath("//button[@type='submit']//span[text()='Сохранить']/parent::*"), "Submit Form Button");

    private final CalendarForm calendarForm = new CalendarForm();
    private final StepsForm stepsForm = new StepsForm();

    public AddProjectForm() {
        super(By.xpath("//label[text()='Номер проекта' and contains(@class, 'mantine-InputWrapper-label')]"), "Add Project Form");
    }

    public boolean isAddProjectFormDisplayed() {
        return numberOfProjectInput.getElement().isDisplayed();
    }

    public boolean isConfirmationWindowDisplayed(Integer numberOfProject) {
        Label confirmationButton = new Label(By.xpath(String.format("//section[contains(@class, 'mantine-Paper-root') and contains(@class, 'mantine-Modal-content')]//p[contains(text(), '%s')]", numberOfProject.toString())), "Confirmation Window");
        DriverUtility.getWaits().waitForDisplayed(confirmationButton.getElement());
        return confirmationButton.getElement().isDisplayed();
    }

    public void clickOnSubmit() {
        submitFormButton.clickElementExecutor();
    }

    public void clickOnEmptyPlace() {
        new Label(By.xpath("//form/div[contains(@class, 'mantine-Group-root')]"), "Empty Place").clickElementExecutor();
    }

    public void inputNumberOfProject(Integer number) {
        numberOfProjectInput.getElement().sendKeys(String.valueOf(number));
    }

    public void inputNameOfProduct() {
        nameOfProductInput.getElement().sendKeys(RandomUtility.getRandomAlphaNumericString());
    }

    public void inputNameOfClient() {
        clientOfProjectInput.getElement().sendKeys(RandomUtility.getRandomAlphaNumericString());
    }

    public void inputComments() {
        commentsInput.getElement().sendKeys(RandomUtility.getRandomAlphaNumericString());
    }

    public void selectDataAfterMonth() {
        dateOfProjectEndingInputEmpty.clickElement();
        calendarForm.clickToTHeNextMonth();
        new Button(By.xpath(String.format("//td[contains(@class, 'mantine-Month-monthCell') and contains(@class, 'mantine-DatePickerInput-monthCell')]//div[text()='%s']", Calendar.getInstance().get(Calendar.DAY_OF_MONTH))), "Day Of month").clickElement();
    }

    public void selectRandomStep() {
        stepsOfProjectInput.clickElement();
        stepsForm.selectRandomStep();
    }

    public boolean isNumberOfProjectsValueAdded() {
        return !numberOfProjectInput.getElement().getAttribute(configUiDTO.getValueAttribute()).isEmpty();
    }

    public boolean isNameOfProductValueAdded() {
        return !nameOfProductInput.getElement().getAttribute(configUiDTO.getValueAttribute()).isEmpty();
    }

    public boolean isClientNameValueAdded() {
        return !clientOfProjectInput.getElement().getAttribute(configUiDTO.getValueAttribute()).isEmpty();
    }

    public boolean isCommentsInputValueAdded() {
        return !commentsInput.getElement().getAttribute(configUiDTO.getValueAttribute()).isEmpty();
    }

    public boolean isDateOfEndValueAdded() {
        return !dateOfProjectEndingInputFilled.getElement().getText().isEmpty();
    }

    public boolean isStepsAdded() {
        return !stepsOfProjectInput.getElement().findElements(By.xpath("//p")).isEmpty();
    }
}
