import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Airbnb;
import pages.SwagbucksPage;
import utilities.Driver;
import utilities.Utilities;

public class Survay {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    pages.SwagbucksPage SwagbucksPage = new SwagbucksPage();
    Utilities utilities = new Utilities();

    @When("do a swugbucks survay")
    public void doASwugbucksSurvay() {
    }
}
