package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class ResultsTests extends BaseTest {

    private String ACTUAL_WORD = "рыба";
    private String EXPECTED_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    private String MESSAGE_LESS_THAN_40 = "Word lorem with probability of less than 40%";
    private int EXPECTED_SIZE = 10;
    private int NUMBER_OF_CHECK = 10;
    private int ACTUAL_RESULT = 0;

    @Test
    public void checkRusTextContainsWord() {
        //getHomePage().implicitWait(20);
        getHomePage().getRusLanguageButton();
        Assert.assertTrue(getHomePage().getRusTextFirstParagraph().contains(ACTUAL_WORD));
    }

    @Test
    public void checkCreateLoremStartWithText() {
        //getHomePage().implicitWait(20);
        getHomePage().getGenerateLoremButton();
        Assert.assertTrue(getResultPage().getTextFirstParagraph().startsWith(EXPECTED_TEXT));
    }

    @Test
    public void checkCreateWordsIsActual() {
        //getHomePage().implicitWait(20);
        getHomePage().getGenerator(10,"words");
        Assert.assertEquals(getResultPage().getWordsActualSize(),10);
        getResultPage().navigateBack();
        getHomePage().getGenerator(0,"words");
        Assert.assertEquals(getResultPage().getWordsActualSize(),5);
        getResultPage().navigateBack();
        getHomePage().getGenerator(-1,"words");
        Assert.assertEquals(getResultPage().getWordsActualSize(),5);
        getResultPage().navigateBack();
        getHomePage().getGenerator(20,"words");
        Assert.assertEquals(getResultPage().getWordsActualSize(),20);
        getResultPage().navigateBack();
        getHomePage().getGenerator(5,"words");
        Assert.assertEquals(getResultPage().getWordsActualSize(),5);
    }

    @Test
    public void checkCreateCharsIsActual() {
        //getHomePage().implicitWait(20);
        getHomePage().getGenerator(10,"bytes");
        Assert.assertEquals(getResultPage().getBytesActualSize(),10);
        getResultPage().navigateBack();
        getHomePage().getGenerator(-10,"bytes");
        Assert.assertEquals(getResultPage().getBytesActualSize(),5);
        getResultPage().navigateBack();
        getHomePage().getGenerator(0,"bytes");
        Assert.assertEquals(getResultPage().getBytesActualSize(),5);
    }

    @Test
    public void checkCreateLoremNotStartWithText() {
        //getHomePage().implicitWait(20);
        getHomePage().getCheckboxBeginWithLorem();
        getHomePage().getGenerateLoremButton();
        Assert.assertFalse(getResultPage().getTextFirstParagraph().startsWith(EXPECTED_TEXT));
    }

    @Test
    public void checkProbabilityContainsWordLorem() {
        //getHomePage().implicitWait(20);
        for(int i = 0; i < NUMBER_OF_CHECK; i++) {
            getHomePage().getGenerateLoremButton();
            ACTUAL_RESULT += getResultPage().getCountParagraphWithLorem();
            getResultPage().navigateBack();
        }
        Assert.assertTrue(ACTUAL_RESULT/NUMBER_OF_CHECK >=2,MESSAGE_LESS_THAN_40);
    }
}
