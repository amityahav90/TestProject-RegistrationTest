package main.Runners;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.classes.DriverSettings;
import io.testproject.java.enums.DriverType;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.Runner;
import main.TestCases.SignupTestCase;
import org.openqa.selenium.WebDriver;

public class SignupPageRunner {

    private final static String devToken = "kNfpUCmY_3Gg_reU2mfsBgRTAq3XizjJDpiQReY813E1";
    private final static String URL = "https://codepen.io/";


    public static void main(String[] args) throws Exception {

        DriverSettings driverSettings = new DriverSettings(DriverType.Chrome);
        try (Runner runner = new Runner(devToken, driverSettings)) {

            SignupTestCase signupTestCase = new SignupTestCase();
            WebDriver driver = runner.getDriver(signupTestCase);
            SignupPage signupPage = new SignupPage(driver);

            driver.navigate().to("https://codepen.io/");

            signupPage.clickSignUpButton();
            Thread.sleep(1500);
            signupPage.clickLoginWithEmail();
            signupPage.enterSignupDetails("Amit Yahav", "amitya", "amit@example.com", "123456");
            signupPage.clickSubmitButton();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
