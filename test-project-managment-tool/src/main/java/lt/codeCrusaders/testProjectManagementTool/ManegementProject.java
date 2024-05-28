package lt.codeCrusaders.testProjectManagementTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManegementProject extends ManagementRegister {

    @FindBy(css = ".new-project-btn")
    WebElement createNewProjectButton;

    @FindBy(css = "input")
    WebElement projectName;

    @FindBy(css = "textarea")
    WebElement projectDescription;

    @FindBy(css = ".form-container > button[type='submit']")
    WebElement submitProjectBtn;

    @FindBy(xpath = "//div[@id='root']//div[@class='content']//form[@class='form-container']//select")
    WebElement priorityDropDown;

    @FindBy(css = ".project-preview")
    List<WebElement> projectPreviews;

    public ManegementProject(WebDriver driver) {
        super(driver);
    }


    public void navigateToProjectCreation() {
        createNewProjectButton.click();
    }

    public void enterProjectName(String name) {
        projectName.sendKeys(name);
    }

    public void enterProjectDescription(String description) {
        projectDescription.sendKeys(description);
    }

    public void submitProject() {
        submitProjectBtn.click();
    }

    public void selectPriority() {
        priorityDropDown.click();
    }
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='Low'", priorityDropDown);
//    }

    public void selectPriorityName(String priority) {
        Select select = new Select(priorityDropDown);
        select.selectByVisibleText(priority);
    }

    public long countProjects() {
        return projectPreviews.size();
    }

    public void proessProjects() {
        projectPreviews.forEach(project -> {
            System.out.println(project.getText());
        });
    }
}
