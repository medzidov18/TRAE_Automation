package selenium.pageobjects;

import base.BaseForm;
import elements.*;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import static dataread.DataRead.configUiDTO;

public class ProjectsPageObject extends BaseForm {
    private final Button addNewProjectButton = new Button(By.xpath("//div[contains(@class, 'mantine-Group-root')]/button/span[text()='Добавить']"), "Add Project Button");
    private final Button paginationBlock = new Button(By.xpath("//div[contains(@class, 'mantine-Group-root')]//p"), "Pagination Block");
    private final Button nextPagePagination = new Button(By.xpath("(//div[contains(@class, 'mantine-Group-root')]//button[@color='--white'])[2]"), "Next Page Button");
    private final Button previousPagePagination = new Button(By.xpath("(//div[contains(@class, 'mantine-Group-root')]//button[@color])[1]"), "Previous Page Button");

    public ProjectsPageObject() {
        super(By.xpath("//div[contains(@class, 'mantine-Stack-root')]/div[contains(@class, 'mantine-Group-root')]"), "Projects Page");
    }

    public void clickOnAddNewButton() {
        addNewProjectButton.getElement().click();
    }

    @SneakyThrows
    public boolean findProjectByNumber(Integer numberOfProject) {
        boolean isRightProject = false;
        Integer countOfPages= Integer.parseInt(getCountOfPages()) + 1;

        for (Integer i = 1; i < countOfPages; i++) {
            if (!isRightProject) {
                Thread.sleep(100);
                List<WebElement> allProjects = Framework.core.DriverUtility.getDriver().findElements(By.xpath("(//div/p[1])[position() <= 10]"));
                for (WebElement project : allProjects) {
                    isRightProject = project.getText().equals(numberOfProject.toString());
                    if (isRightProject) break;
                }
            }
            if (isRightProject) break;
            goToNextPage();
            Thread.sleep(100);
        }

        return isRightProject;
    }

    public void goToNextPage() {
        Framework.core.DriverUtility.getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", nextPagePagination.getElement());
        Framework.core.DriverUtility.getJavaScriptExecutor().executeScript("arguments[0].click();", nextPagePagination.getElement());
    }

    public String getCountOfPages() {
        return paginationBlock.getElement().getText().substring(paginationBlock.getElement().getText().length() - 1);
    }
}
