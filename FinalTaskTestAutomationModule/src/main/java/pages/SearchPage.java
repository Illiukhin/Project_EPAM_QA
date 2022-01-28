package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//div[contains(@class,'title-')]//h2")
    private List<WebElement> titles;

    @FindBy(xpath = "//span[contains(@class,'a-size-medium a-color-base ')]")
    private List<WebElement> products;

    @FindBy(xpath = "//div[contains(@class,'apbSearchResultItem')]")
    private List<WebElement> productsVG;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base a-text-normal']")
    private WebElement resultSearch;

    public String firstProductTitleText() { return titles.get(0).getText();}

    public void chooseProductByNumber(int number) { products.get(number-1).click();}

    public int countProductsInThePage() { return titles.size();}

    public int countProductsVGInThePage() { return productsVG.size();}

    public int expectedResultSearch() { return Integer.parseInt(resultSearch.getText().substring(2,4));}

    public List<WebElement> getSearchResultTitles() { return titles;}
}
