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
import pages.HomePage;
import pages.ResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    HomePage homePage;
    ResultPage resultPage;
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
        homePage.implicitWait(DEFAULT_TIMEOUT);
    }

    @When("User chooses Russian language")
    public void userChoosesRussianLanguage() {
        homePage.implicitWait(DEFAULT_TIMEOUT);
        homePage.getRusLanguageButton();
    }

    @Then("User checks that text first paragraph contains word {string}")
    public void userChecksThatTextFirstParagraphContainsWord(final String word) {
        homePage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.getTextFirstParagraph().contains(word));
    }

    @When("User generates a new lorem")
    public void userGeneratesANewLorem() {
        homePage.getGenerateLoremButton();
    }

    @Then("User checks that the created Lorem starts with text {string}")
    public void userChecksThatTheCreatedLoremStartsWithTextText(final String text) {
        resultPage = pageFactoryManager.getResultPage();
        resultPage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertTrue(resultPage.getTextFirstParagraph().startsWith(text));
    }

    @And("User generates lorem with {string}")
    public void userGeneratesLoremWithElement(final String element) {
        homePage.getGenerateElement(element);
    }

    @When("User input an element {string}")
    public void userInputAnElementCount(final String count) {
        homePage.implicitWait(DEFAULT_TIMEOUT);
        homePage.getInputInEntryField(count);
    }

    @When("User disables checkbox begin with lorem")
    public void userDisablesCheckboxBeginWithLorem() {
        homePage.getCheckboxBeginWithLorem();
    }

    @Then("User checking created lorem not start with {string}")
    public void userCheckingCreatedLoremNotStartWithText(final String text) {
        resultPage = pageFactoryManager.getResultPage();
        resultPage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertFalse(resultPage.getTextFirstParagraph().startsWith(text));
    }

    @Then("User Checking created word lorem is the {string}")
    public void userCheckingCreatedWordLoremIsTheExpected_result(final String expected_result) {
        resultPage = pageFactoryManager.getResultPage();
        resultPage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertEquals(resultPage.getWordsActualSize(),Integer.parseInt(expected_result));
    }

    @Then("User Checking created bytes lorem is the {string}")
    public void userCheckingCreatedBytesLoremIsTheExpected_result(final String expected_result) {
        resultPage = pageFactoryManager.getResultPage();
        resultPage.implicitWait(DEFAULT_TIMEOUT);
        Assert.assertEquals(resultPage.getBytesActualSize(),Integer.parseInt(expected_result));
    }

}
