package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    private WebElement buttonLanguageCurrency;

    @FindBy(xpath = "//span[@class='icp-currency-symbol']")
    private WebElement currencySymbol;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement buttonGoSearch;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement buttonMenu;

    @FindBy(xpath = "//a[@data-menu-id='6']")
    private WebElement buttonSelectComputer;

    @FindBy(xpath = "//a[text()='Monitors']")
    private WebElement buttonSelectMonitors;

    @FindBy(id = "gw-sign-in-button")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//img[@alt='Headsets']")
    private WebElement gamingHeadsets;

    @FindBy(xpath = "//a[@aria-label='Video Games']")
    private WebElement videoGames;

    @FindBy(xpath = "//a[contains(@href,'registry')]")
    private WebElement buttonRegistry;

    @FindBy(id = "nav-global-location-slot")
    private WebElement buttonLocation;

    @FindBy(id = "nav-swmslot")
    private WebElement buttonNewDeals;

    @FindBy(id="nav-cart-count")
    private WebElement countAddedProducts;

    @FindBy(xpath = "//span[contains(@class,'button-dismiss')]")
    private WebElement buttonCloseLocation;

    public void goToLanguageAndCurrencySetting() { buttonLanguageCurrency.click();}

    public void openMenu() { buttonMenu.click();}

    public void selectComputers() { buttonSelectComputer.click();}

    public void selectMonitors() { buttonSelectMonitors.click();}

    public void selectSignIn() { buttonSignIn.click();}

    public void selectHeadsets() { gamingHeadsets.click();}

    public void selectVideoGames() { videoGames.click();}

    public void selectRegistry() { buttonRegistry.click();}

    public void selectNewDeals() { buttonNewDeals.click();}

    public String getCurrencySymbol() { return currencySymbol.getText();}

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void searchByWord(String word) {
        searchField.click();
        searchField.sendKeys(word);
        buttonGoSearch.click();
    }

    public WebElement waitButtonRegistry() { return buttonRegistry;}

    public WebElement waitButtonComputers() { return buttonSelectComputer;}

    public WebElement waitButtonMonitors() { return buttonSelectMonitors;}

    public void closeLocation() {
        try {
           buttonCloseLocation.click();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            driver.manage();
        }
    }
}
