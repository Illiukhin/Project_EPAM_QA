package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistryPage extends BasePage {

    public RegistryPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//div[contains(@class,'search-button')]")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[contains(@class,'name-alert')]")
    private WebElement nameInputError;

    public void clickSearchButton() { buttonSearch.click();}

    public String textErrorName() { return nameInputError.getAttribute("innerText");}
}
