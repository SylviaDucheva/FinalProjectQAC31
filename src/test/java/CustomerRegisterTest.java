import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerRegisterTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void shutDown() {
        driver.quit();
    }

    @Test

    public void completeTest() {
        openRegisterForm();
        fillInRegisterForm();
        checkIfRegistered();
    }

    public void openRegisterForm() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[\"Register Account\"]")));
    }

    public void fillInRegisterForm() {
        driver.findElement(By.id("input-firstname")).sendKeys("Sylvia");
        driver.findElement(By.id("input-lastname")).sendKeys("Ducheva");
        WebElement emailField = driver.findElement(By.id("input-email"));
        String prefix = RandomStringUtils.randomAlphanumeric(7);
        String suffix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = prefix + "@" + suffix + ".com";
        emailField.sendKeys(emailAddress);
        driver.findElement(By.id("input-telephone")).sendKeys("0888444333");
        driver.findElement(By.id("input-password")).sendKeys("P@ssw0rd123!");
        driver.findElement(By.id("input-confirm")).sendKeys("P@ssw0rd123!");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();

//        WebElement privacyPolicy = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
//        Actions selector = new Actions(driver);
//        if (privacyPolicy.isEnabled()) {
//            if (!privacyPolicy.isSelected()) {
//                selector.moveToElement(privacyPolicy).click().build().perform();
//            } else {
//                System.out.println("This option is disabled");
//            }
//
//        }

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }

    public void checkIfRegistered() {
        WebElement heather = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[\"Your Account Has Been Created!\"]")));
        Assert.assertEquals(heather.getText(), "Your Account Has Been Created!");
    }
}

//Използвайки Selenium WebDriver и TestNG, напишете
//автоматизиран позитивен тест, който:
//1. Отива на http://shop.pragmatic.bg;
//2. Клика върху надписа “My Account” в горния край на екрана;
//3. Клика върху надписа “Register”;
//4. Регистрира нов потребител като:
//- попълва задължителните полета,
//- селектира задължителните чекбоксове,
//- клика върху бутона “Continue”;
//5. Потвърждава успешната регистрация на новия потребител.