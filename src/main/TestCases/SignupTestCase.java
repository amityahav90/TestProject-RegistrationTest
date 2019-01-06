package main.TestCases;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import main.Runners.SignupPage;

@Test(name = "Signup Test")
public class SignupTestCase implements WebTest {

    @Parameter(defaultValue = "John Doe")
    public String name;

    @Parameter(defaultValue = "JohnTheOriginal123321")
    public String username;

    @Parameter(defaultValue = "amitya@ac.sce.ac.il")
    public String email;

    @Parameter(defaultValue = "password123")
    public String password;


    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {

        WebDriver driver = webTestHelper.getDriver();
        SignupPage signupPage = new SignupPage(driver);


        driver.navigate().to("https://codepen.io/");

        signupPage.clickSignUpButton();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signupPage.clickLoginWithEmail();
        signupPage.enterSignupDetails(name, username, email, password);
        signupPage.clickSubmitButton();

        return ExecutionResult.PASSED;
    }
}
