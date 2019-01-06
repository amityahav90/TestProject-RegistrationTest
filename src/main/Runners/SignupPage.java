package main.Runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "signup-button")
    private WebElement btnSignup;

    @FindBy(className = "email-button")
    private WebElement btnSignupWithEmail;

    @FindBy(id = "signup-name-field")
    private WebElement txtName;

    @FindBy(id = "signup-username-field")
    private WebElement txtUsername;

    @FindBy(id = "signup-email-field")
    private WebElement txtEmail;

    @FindBy(id = "signup-password-field_")
    private WebElement txtPassword;

    @FindBy(id = "user-new-submit")
    private WebElement btnSubmit;

    public void clickSignUpButton() {
        this.btnSignup.click();
    }

    public void clickLoginWithEmail() {
        this.btnSignupWithEmail.click();
    }

    public void enterSignupDetails(String name, String username, String email, String password) {
        this.txtName.sendKeys(name);
        this.txtUsername.sendKeys(username);
        this.txtEmail.sendKeys(email);
        this.txtPassword.sendKeys(password);
    }

    public void clickSubmitButton() {
        this.btnSubmit.submit();
    }
}
