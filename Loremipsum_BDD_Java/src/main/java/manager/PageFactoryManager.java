package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultPage;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver);}

    public ResultPage getResultPage() { return new ResultPage(driver);}

}
