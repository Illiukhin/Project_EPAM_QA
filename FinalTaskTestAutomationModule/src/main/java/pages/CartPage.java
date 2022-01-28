package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) { super(driver);}

    @FindBy(id ="sc-subtotal-label-buybox")
    private WebElement subtotalBuyBox;

    @FindBy(xpath = "//h1[contains(@class,'top')]")
    private WebElement textInTheCart;

    @FindBy(xpath = "//input[@value='Delete']/parent::span")
    private WebElement buttonDeleteProduct;

    public int countBuyProducts() {
        return Integer.parseInt(subtotalBuyBox.getText().replaceAll("[^0-9]", ""));
    }
    public String getTextInTheCart(){ return textInTheCart.getText();}

    public void removeProductFromCart() { buttonDeleteProduct.click();}

    public WebElement waitTextInTheCart() { return textInTheCart;}

    public WebElement waitRemoveProduct() { return buttonDeleteProduct;}
}
