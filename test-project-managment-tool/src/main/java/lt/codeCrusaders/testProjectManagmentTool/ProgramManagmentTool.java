package lt.codeCrusaders.testProjectManagmentTool;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ProgramManagmentTool extends BasePage{


    @FindBy(css = "[href='\\/login']")
    WebElement pressLoginButton;

//    @FindBy(css = "input#user-name")
//    private WebElement userName;

    @FindBy(css = "[name='username']")
    WebElement inputName;
    @FindBy(css = "input#password")
    WebElement inputPassword;

    @FindBy(xpath = "/html//div[@id='root']//form/button[@type='submit']")
    WebElement pressLogin;


    @FindBy(css ="[data-test='error-button']")
    WebElement errorText;

    public ProgramManagmentTool(WebDriver driver) {
        super(driver);
    }

//    public String loginName() {
//        return userName.getText().substring(userName.getText().lastIndexOf(" ") +1);
//    }

    public void pressLoginButtonOnNavBar(){
        pressLoginButton.click();
    }

//    public void waitTime(){
//        Wait<WebDriver> wait =
//                new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(2))
//                        .pollingEvery(Duration.ofMillis(300))
//                        .ignoring(ElementNotInteractableException.class);
//
//        wait.until(
//                d -> {
//                    revealed.sendKeys("Displayed");
//                    return true;
//                });
//    }

    public void pasteNameToInput(String username) {
        inputName.sendKeys(username);
    }

    public void pastePasswordToInput(String userPassword) {
        inputPassword.sendKeys(userPassword);
    }

    public void pressLoginButton() {
        pressLogin.click();
    }

    public String getErrorTextMessage() {
        return errorText.getText();
    }

}
