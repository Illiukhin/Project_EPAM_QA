package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends BasePage {

    public DealsPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//span[text()='Beauty']")
    private WebElement buttonBeauty;

    @FindBy(xpath = "//span[text()='Beauty']/preceding-sibling::input")
    private WebElement checkboxBeauty;

    public void selectBeauty() { buttonBeauty.click();}

    public boolean isTurnCheckbox() { return Boolean.valueOf(checkboxBeauty.getAttribute("checked"));}
}
