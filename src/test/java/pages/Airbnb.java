package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class Airbnb {

    public Airbnb() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@aria-label='Location']")
    public WebElement locationInput;

    @FindBy(id = "checkin_button")
    public WebElement checkIn;

    @FindBy(id = "checkout_button")
    public WebElement checkOut;

    @FindBy(xpath = "//select[@name='adults']")
    public WebElement selectAdults;

    @FindBy(xpath = "//div[@data-testid='calendar-nav-next']/button")
    public WebElement nextMonthButton;

    @FindBy(id = "submit_btn")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[@aria-label='Add listing to a list']/..")
    public List<WebElement> houseNameList;

    @FindBy(xpath = "//button[@aria-label='Add listing to a list']/../../div[3]/span[3]")
    public List<WebElement> bedroomNumberList;

    @FindBy(xpath = "//button[@aria-label='Add listing to a list']/../../div[3]/span[1]")
    public List<WebElement> ocupancyList;

    @FindBy(xpath = "//button[@aria-label='Add listing to a list']/../../div[3]/span[5]")
    public List<WebElement> numberOfBedsList;

    @FindBy(xpath = "//button[@aria-label='Add listing to a list']/../..//*[contains(text(),'per night')]")
    public List<WebElement> pricingTextList;

    @FindBy(xpath = "//a[@aria-label='Next']")
    public WebElement nextPaqe;


    public void selectAdults(String value) {
        Select select = new Select(selectAdults);
        select.selectByVisibleText(value);
    }

    public String getHousePrice(String fullPriceText) {
        return fullPriceText.substring(0, fullPriceText.indexOf(" per night"));
    }


}
