package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage(String url) {
        driver.get(url);
    }

    protected void clickOnWebElement(WebElement webElement) {
        webElement.click();
    }

    protected void typeInWebElement(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public void verifyWebElementIsPresent(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());
    }
}


