package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//input[@value='Add to Cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//form[contains(@id,'cart-button')]")
    private WebElement buttonGoToCart;

    public void productAddToCart() { buttonAddToCart.click();}

    public void goToCart() { buttonGoToCart.click();}

    public WebElement waitGoToCart() { return buttonGoToCart;}

}
