package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainShopPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement register;

    private static final String URL = "http://shop.pragmatic.bg/";

    public MainShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToShopPage() {
        goToPage(URL);
    }

    public void clickOnMyAccount() {
        clickOnWebElement(myAccount);
    }

    public void clickOnRegister() {
        clickOnWebElement(register);
    }

}

