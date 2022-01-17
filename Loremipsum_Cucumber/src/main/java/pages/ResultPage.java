package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> elementsAllParagraph;

    public String getTextFirstParagraph() {
        return firstParagraph.getText();
    }

    public int getWordsActualSize() {
        return getTextFirstParagraph().split(" ").length;
    }

    public int getBytesActualSize() {
        return getTextFirstParagraph().getBytes(StandardCharsets.UTF_8).length;
    }

    public int getCountParagraphWithLorem() {
        int count = 0;
        for (WebElement webElement : elementsAllParagraph) {
            if (webElement.getText().contains("lorem")) {count++;}
        }
        return count;
    }
}
