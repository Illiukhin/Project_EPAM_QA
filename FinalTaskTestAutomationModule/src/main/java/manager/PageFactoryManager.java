package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver);}

    public SettingPage getSettingPage() { return new SettingPage(driver);}

    public SearchPage getSearchPage() { return new SearchPage(driver);}

    public SignInPage getSignInPage() { return new SignInPage(driver);}

    public ProductPage getProductPage() { return new ProductPage(driver);}

    public CartPage getCartPage() { return new CartPage(driver);}

    public RegistryPage getRegistryPage() { return new RegistryPage(driver);}

    public DealsPage getDealsPage() { return new DealsPage(driver);}
}
