package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage extends BasePage {

    public SettingPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//span[contains(@class,'button-dropdown')]")
    private WebElement buttonCurrency;

    @FindBy(id = "icp-sc-dropdown_23")
    private WebElement changeEuro;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement buttonSaveChanges;

    public void selectCurrencyEuro() {
        buttonCurrency.click();
        changeEuro.click();
        buttonSaveChanges.click();
    }
}
