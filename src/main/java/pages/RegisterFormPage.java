package pages;

import base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterFormPage extends BasePage {

    public RegisterFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement telephoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueBtn;

    @FindBy(xpath = "//h1[\"Register Account\"]")
    private WebElement header;

    private void fillInFirstname() {
        typeInWebElement(firstName, "Sylvia");
    }

    private void fillInLastName() {
        typeInWebElement(lastName, "Ducheva");
    }

    private void fillInEmailAddress() {
        String prefix = RandomStringUtils.randomAlphanumeric(7);
        String suffix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = prefix + "@" + suffix + ".com";
        typeInWebElement(emailField, emailAddress);
    }

    private void fillInTelephone() {
        typeInWebElement(telephoneField, "0888555666");
    }

    private void fillInPassword() {
        typeInWebElement(passwordField, "P@ss789!");
    }

    private void confirmPassword() {
        typeInWebElement(confirmPasswordField, "P@ss789!");
    }

    public void markPrivacyPolicy() {
        clickOnWebElement(privacyPolicy);
    }

    public void clickContinue() {
        clickOnWebElement(continueBtn);
    }

    public void checkPage() {
        verifyWebElementIsPresent(header);
    }

    public void fillInRegisterForm() {
        fillInFirstname();
        fillInLastName();
        fillInEmailAddress();
        fillInTelephone();
        fillInPassword();
        confirmPassword();
    }

}


