package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public abstract class BasePage {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage() {
        PageFactory.initElements(driver, this);
    }
}
