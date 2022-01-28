package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    SettingPage settingPage;
    SearchPage searchPage;
    SignInPage signInPage;
    CartPage cartPage;
    RegistryPage registryPage;
    DealsPage dealsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User go to language and currency setting")
    public void userGoToLanguageAndCurrencySetting() {
        homePage.goToLanguageAndCurrencySetting();
    }

    @When("User select currency Euro")
    public void userSelectCurrencyEuro() {
        settingPage = pageFactoryManager.getSettingPage();
        settingPage.selectCurrencyEuro();
    }

    @Then("User checks by {string} that change of Currency in Euro")
    public void userChecksBySymbolThatChangeOfCurrencyInEuro(final String symbol) {
        homePage = pageFactoryManager.getHomePage();
        homePage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertEquals(homePage.getCurrencySymbol(), symbol);
    }

    @When("User search by word {string}")
    public void userSearchByWordHarryPotter(final String word) {
        homePage.searchByWord(word);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User Check that search results contains search word {string}")
    public void userCheckThatSearchResultsContainsSearchWordHarryPotter(final String word) {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.firstProductTitleText().contains(word));
    }

    @When("User opens menu")
    public void userOpensMenu() {
        homePage.openMenu();
    }

    @And("User select computers")
    public void userSelectComputers() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.waitButtonComputers());
        homePage.selectComputers();
    }

    @And("User select monitors")
    public void userSelectMonitors() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.waitButtonMonitors());
        homePage.selectMonitors();
    }


    @Then("User checks the number <{int}> of items on the search page")
    public void userChecksTheNumberOfItemsOnTheSearchPage(final int number) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(searchPage.countProductsInThePage(),number);
    }

    @When("User select button SignIn")
    public void userSelectButtonSignIn() {
        homePage.selectSignIn();
    }


    @And("User enters into the field incorrect phone {string}")
    public void userEntersIntoTheFieldIncorrectPhone(final String phone) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterPhoneOrEmail(phone);
    }

    @And("User select button continue")
    public void userSelectButtonContinue() {
        signInPage.selectContinue();
    }

    @Then("User compares error message with message {string}")
    public void userComparesErrorMessageWithMessageIncorrectPhoneNumber(final String message) {
        Assert.assertEquals(signInPage.getErrorMessage(),message);
    }

    @When("User select menu headsets")
    public void userSelectMenuHeadsets() {
        homePage.selectHeadsets();
    }

    @And("User product add to cart")
    public void userProductAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.implicitWait(DEFAULT_TIMEOUT);
        productPage.productAddToCart();
    }

    @And("User go to cart")
    public void userGoToCart() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.waitGoToCart());
        productPage.goToCart();
    }

    @Then("User checks the count <{int}> product in the cart")
    public void userChecksTheCountProductInTheCart(final int count) {
        cartPage = pageFactoryManager.getCartPage();
        Assert.assertEquals(cartPage.countBuyProducts(),count);
    }

    @And("User choose product by <{int}> position")
    public void userChooseProductByPosition(final int number) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.chooseProductByNumber(number);
    }

    @When("User selects the menu registry")
    public void userSelectsTheMenuRegistry() {
        homePage.closeLocation();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.waitButtonRegistry());
        homePage.selectRegistry();
    }

    @And("User on the registry page click search button")
    public void userOnTheRegistryPageClickSearchButton() {
        registryPage = pageFactoryManager.getRegistryPage();
        registryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registryPage.clickSearchButton();
    }

    @Then("User checks error in menu registry is name {string}")
    public void userChecksErrorInMenuRegistryIsNamePleaseEnterARegistrantName(final String message) {
        Assert.assertEquals(registryPage.textErrorName(),message);
    }

    @When("User selects the menu video game")
    public void userSelectsTheMenuVideoGame() {
        homePage.selectVideoGames();
    }

    @Then("User checks label count search video game in the page")
    public void userChecksLabelCountSearchVideoGameInThePage() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(searchPage.expectedResultSearch(),searchPage.countProductsVGInThePage());
    }

    @When("User select menu NewDeals")
    public void userSelectMenuNewDeals() {
        homePage.selectNewDeals();
    }

    @And("User select bar beauty")
    public void userSelectBarBeauty() {
        dealsPage = pageFactoryManager.getDealsPage();
        dealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        dealsPage.selectBeauty();
    }

    @Then("User checks that is turn checkbox beauty")
    public void userChecksThatIsTurnCheckboxBeauty() {
        dealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(dealsPage.isTurnCheckbox());
    }

    @Then("User checks that all titles contains search word {string}")
    public void userChecksThatAllTitlesContainsSearchWordUkraine(final String word) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : searchPage.getSearchResultTitles()) {
            assertTrue(webElement.getText().contains(word));
        }
    }

    @And("User add to cart product")
    public void userAddToCartProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.implicitWait(DEFAULT_TIMEOUT);
        productPage.productAddToCart();
    }

    @And("User remove product from cart")
    public void userRemoveProductFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.waitRemoveProduct());
        cartPage.removeProductFromCart();
    }

    @Then("User checks text in the cart is name {string}")
    public void userChecksTextInTheCartIsNameYourAmazonCartIsEmpty(final String text) {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.waitTextInTheCart());
        Assert.assertEquals(cartPage.getTextInTheCart(),text);
    }
}
