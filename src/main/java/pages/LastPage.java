package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastPage extends BasePage {

    public LastPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[\"Your Account Has Been Created!\"]")
    private WebElement header2;

    public void checkIfHeaderIsPresent() {
        verifyWebElementIsPresent(header2);
    }

}
