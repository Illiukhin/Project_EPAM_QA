package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) { super(driver);}

    @FindBy(id = "ap_email")
    private WebElement fieldEmail;

    @FindBy(id = "continue")
    private WebElement buttonContinue;

    @FindBy(xpath = "//div[contains(@class,'box')]//h4")
    private WebElement errorBox;

    public void enterPhoneOrEmail(String email){ fieldEmail.sendKeys(email);}

    public void selectContinue() { buttonContinue.click();}

    public String getErrorMessage() { return errorBox.getText();}
}
