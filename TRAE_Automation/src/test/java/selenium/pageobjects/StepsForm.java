package selenium.pageobjects;

import base.BaseForm;
import core.DriverUtility;
import elements.*;
import org.openqa.selenium.By;

import java.util.Random;

import static dataread.DataRead.testDataUiDTO;

public class StepsForm extends BaseForm {
    private final Random random = new Random();

    public StepsForm() {
        super(By.xpath("//div[@role='menu']"), "Steps Form");
    }

    public void selectRandomStep() {
        Integer randomstep = random.nextInt(getcountOfAllSteps() - testDataUiDTO.getMinCountOfSteps() + 1) + testDataUiDTO.getMinCountOfSteps();
        Button stepButton = new Button(By.xpath(String.format("(//button[@role='menuitem']//span[1])[%s]", randomstep)), "Random Step");
        stepButton.clickElementExecutor();
    }

    private Integer getcountOfAllSteps() {
        return DriverUtility.getDriver().findElements(By.xpath("//button[@role='menuitem']")).size();
    }
}
