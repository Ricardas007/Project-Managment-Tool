package lt.codeCrusaders.testProjectManagementTool;
//import com.google.common.collect.CollectSpliterators;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ProgramManagmentToolTest extends BaseTest{
    @Description("Register to app with valid credentials")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Reg1.csv", numLinesToSkip = 1)
    void registerToPage(String username, String userEmail, String userPassword) throws InterruptedException {
        ManagementRegister registerPage = new ManagementRegister(driver);
        registerPage.pressRegisterButtonOnNavBar();
        registerPage.registerInputName(username);
        registerPage.registerInputEmail(userEmail);
        registerPage.registerInputPassword(userPassword);
        registerPage.registerInputConfPass(userPassword);
        Thread.sleep(3000);
        registerPage.pressRegisterBtn();

    }

    @Description("Login with valid credentials")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/loginPositive.csv", numLinesToSkip = 1)
    void loginPageTesLogin(String username, String userPassword) {
        ManagementLogin loginPage = new ManagementLogin(driver);
        loginPage.pressLoginButtonOnNavBar();
        loginPage.pasteNameToInput(username);
        loginPage.pastePasswordToInput(userPassword);
        loginPage.pressLoginButton();
        String loggedUserName = loginPage.checkLoggedUserName();
        Assertions.assertEquals(username, loggedUserName);
    }

    @Description("Login with invalid credentials test")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Book1.csv", numLinesToSkip = 1)
    void loginPageTestIncorrectPassword(String username, String userPassword, String expectedMessage) {
        ManagementLogin loginPage = new ManagementLogin(driver);
        loginPage.pressLoginButtonOnNavBar();
        loginPage.pasteNameToInput(username);
        loginPage.pastePasswordToInput(userPassword);
        loginPage.pressLoginButton();

        String actualAlertMessage = loginPage.alertMessageText();
        Assertions.assertEquals(expectedMessage, actualAlertMessage);
    }

    @Description("Admin login test")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/admin.csv", numLinesToSkip = 1)
    void loginPageTestLoginAsAdmin(String adminName, String adminPassword) {
        ManagementLogin loginPage = new ManagementLogin(driver);
        loginPage.pressLoginButtonOnNavBar();
        loginPage.pasteNameToInput(adminName);
        loginPage.pastePasswordToInput(adminPassword);
        loginPage.pressLoginButton();
        String loggedUserName = loginPage.checkLoggedUserName();
        System.out.println(loggedUserName);
        Assertions.assertEquals(adminName, loggedUserName, "Checking who is logged in");
    }

    @Description("Login with invalid credentials")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Book1.csv", numLinesToSkip = 1)
    void loginPageTestEmptyNameField(String username, String userPassword, String expectedMessage) {
        ManagementLogin loginPage = new ManagementLogin(driver);
        loginPage.pressLoginButtonOnNavBar();
        loginPage.pasteNameToInput(username);
        loginPage.pastePasswordToInput(userPassword);
        loginPage.pressLoginButton();
        String actualAlertMessage = loginPage.alertMessageText();
        Assertions.assertEquals(expectedMessage, actualAlertMessage);
//        String loggedUserName = loginPage.checkLoggedUserName();
//        Assertions.assertEquals(username, loggedUserName);
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Project.csv", numLinesToSkip = 1)
    void createProjects(String projectName, String projectDescription) throws InterruptedException {
        ManegementProject project = new ManegementProject(driver);
        project.pressLoginButtonOnNavBar();
        String username = "Frankie1";
        project.pasteNameToInput(username);
        String userPassword = "Frankie1";
        project.pastePasswordToInput(userPassword);
        project.pressLoginButton();

        project.navigateToProjectCreation();
        project.enterProjectName(projectName);
        project.enterProjectDescription(projectDescription);
        project.submitProject();
        System.out.println("Created " + projectName);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Project.csv", numLinesToSkip = 1)
    void createProjects() {
        ManegementProject project = new ManegementProject(driver);
        project.pressLoginButtonOnNavBar();
        String username = "Frankie1";
        project.pasteNameToInput(username);
        String userPassword = "Frankie1";
        project.pastePasswordToInput(userPassword);
        project.pressLoginButton();
        new ManegementProject(driver);
        for (int i = 1; i <= 20; i++) {
            String projectName = "Project " + i;
            project.navigateToProjectCreation();
            project.enterProjectName(projectName);
            String projectDescription = "Description " + i;
            project.enterProjectDescription(projectDescription);
            project.selectPriority();
            project.selectPriorityName("Low");
            project.submitProject();
            System.out.println("Created " + projectName);
        }
    }

    @Test
    public void testCountProjects(){
        ManegementProject project = new ManegementProject(driver);

        long projectCount = project.countProjects();
        System.out.println("Number of projects: " + projectCount);

        Assertions.assertTrue(projectCount > 0, "There should be at least one project");
    }


}
