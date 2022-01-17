package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://ru.lipsum.com/']")
    private WebElement chooseRusLanguage;

    @FindBy(xpath = "//input[@id='generate']")
    private WebElement generateLorem;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxBeginWithLorem;

    @FindBy(xpath = "(//div[@id='Panes']//p)[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//label[@for='word']")
    private WebElement wordGenerator;

    @FindBy(xpath = "//label[@for='bytes']")
    private WebElement bytesGenerator;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement entryField;

    public void getRusLanguageButton() {
        chooseRusLanguage.click();
    }

    public void getGenerateLoremButton() {
        generateLorem.click();
    }

    public String getTextFirstParagraph() {
        return firstParagraph.getText();
    }

    public void getCheckboxBeginWithLorem() {
        checkboxBeginWithLorem.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void getInputInEntryField(String count) {
        entryField.click();
        entryField.clear();
        entryField.sendKeys(count);
    }

    public void getGenerateElement(String element){
        driver.findElement(By.xpath("//label[@for='"+element+"']")).click();
        getGenerateLoremButton();
    }

    public void getGenerator(String count,String element) {
        getInputInEntryField(count);
        driver.findElement(By.xpath("//label[@for='"+element+"']")).click();
        getGenerateLoremButton();
    }
}
