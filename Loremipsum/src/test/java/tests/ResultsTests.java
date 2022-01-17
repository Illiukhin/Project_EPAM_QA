package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultsTests extends BaseTest {

    private final String ACTUAL_WORD = "рыба";
    private final String EXPECTED_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    private final String MESSAGE_LESS_THAN_40 = "Word lorem with probability of less than 40%";
    private final int EXPECTED_SIZE = 10;
    private final int NUMBER_OF_CHECK = 10;
    private  int ACTUAL_RESULT = 0;

    @Test
    public void checkRusTextContainsWord() {
        getHomePage().getRusLanguageButton();
        Assert.assertTrue(getHomePage().getRusTextFirstParagraph().contains(ACTUAL_WORD));
    }

    @Test
    public void checkCreateLoremStartWithText() {
        getHomePage().getGenerateLoremButton();
        Assert.assertTrue(getResultPage().getTextFirstParagraph().startsWith(EXPECTED_TEXT));
    }

    @Test
    public void checkCreateWordsIsActual() {
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
        getHomePage().getCheckboxBeginWithLorem();
        getHomePage().getGenerateLoremButton();
        Assert.assertFalse(getResultPage().getTextFirstParagraph().startsWith(EXPECTED_TEXT));
    }

    @Test
    public void checkProbabilityContainsWordLorem() {
        for(int i = 1; i <= NUMBER_OF_CHECK; i++) {
            getHomePage().getGenerateLoremButton();
            ACTUAL_RESULT += getResultPage().getCountParagraphWithLorem();
            getResultPage().navigateBack();
        }
        Assert.assertTrue(ACTUAL_RESULT/NUMBER_OF_CHECK >=2,MESSAGE_LESS_THAN_40);
    }
}
