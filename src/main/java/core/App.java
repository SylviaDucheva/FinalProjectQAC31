package core;

import org.openqa.selenium.WebDriver;
import pages.LastPage;
import pages.MainShopPage;
import pages.RegisterFormPage;

public class App {
    private WebDriver driver;

    private MainShopPage mainShopPage;
    private RegisterFormPage registerFormPage;
    private LastPage lastPage;

    public App(WebDriver driver) {
        this.driver = driver;
    }

    public MainShopPage mainShopPage() {
        if (mainShopPage == null) {
            mainShopPage = new MainShopPage(driver);
        }
        return mainShopPage;
    }

    public RegisterFormPage registerFormPage() {
        if (registerFormPage == null) {
            registerFormPage = new RegisterFormPage(driver);
        }
        return registerFormPage;
    }

    public LastPage lastPage() {
        if (lastPage == null) {
            lastPage = new LastPage(driver);
        }
        return lastPage;
    }
}

