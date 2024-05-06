package lt.codeCrusaders.testProjectManagmentTool;
import com.google.common.collect.CollectSpliterators;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

public class ProgramManagmentToolTest extends BaseTest{
    private String username = "Frankie";
    private String userEmail = "frankis@gmail.com";
    private String userPassword = "seCret_code1";

    @Test
    void loginToPage() throws InterruptedException {
        ProgramManagmentTool loginPage = new ProgramManagmentTool(driver);
//        username = loginPage.loginName();
        loginPage.pressLoginButtonOnNavBar();
        loginPage.pasteNameToInput(username);
        loginPage.pastePasswordToInput(userPassword);
        Thread.sleep(2000);
        loginPage.pressLoginButton();
//        loginPage.getErrorTextMessage();
        Thread.sleep(2000);
//        driver.wait();
    }

    @Test
    void registerToPage() throws InterruptedException {
        Register registerPage = new Register(driver);
        registerPage.pressRegisterButtonOnNavBar();
        registerPage.registerInputName(username);
        registerPage.registerInputEmail(userEmail);
        registerPage.registerInputPassword(userPassword);
        registerPage.registerInputConfPass(userPassword);
        registerPage.pressRegisterBtn();
        Thread.sleep(2000);
        registerPage.getAllert();

        Alert alert;
        alert.accept();
    }


}
