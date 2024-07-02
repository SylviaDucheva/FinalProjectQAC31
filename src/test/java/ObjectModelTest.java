import org.testng.annotations.Test;

public class ObjectModelTest extends BaseTest {

    @Test
    public void testMainPage() {
        app.mainShopPage().goToShopPage();
        app.mainShopPage().clickOnMyAccount();
        app.mainShopPage().clickOnRegister();
        app.registerFormPage().checkPage();

        app.registerFormPage().fillInRegisterForm();
        app.registerFormPage().markPrivacyPolicy();
        app.registerFormPage().clickContinue();

        app.lastPage().checkIfHeaderIsPresent();
    }

//    @Test
//    public void testRegisterFormPage() {
//        app.registerFormPage().fillInRegisterForm();
//        app.registerFormPage().markPrivacyPolicy();
//        app.registerFormPage().clickContinue();
//    }
//
//    @Test
//    public void checkIfRegistered() {
//        app.lastPage().checkIfHeaderIsPresent();
//    }

}
