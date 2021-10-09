package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Airbnb;

import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ExcelWriter;
import utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentStepDefinitions {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Airbnb airbnbPage = new Airbnb();
    Utilities utilities = new Utilities();
    ExcelWriter excelWriter = new ExcelWriter();


    @When("I calculate rbnb house prices {int} people")
    public void iCalculateRbnbHousePricesPeople(int persons) throws InterruptedException, IOException {
        int n = 0;
        driver.get("https://www.airbnb.com/a/stays/");
        wait.until(ExpectedConditions.titleIs("Find homes in United States on Airbnb"));

        String value = airbnbPage.locationInput.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            airbnbPage.locationInput.sendKeys(Keys.BACK_SPACE);
        }

        airbnbPage.locationInput.sendKeys("Big Bear Lake, CA");

        airbnbPage.locationInput.sendKeys(Keys.TAB);
        Map<String, List<Map<String, String>>> houseListMap = new HashMap<>();

        for (int i = 1; i < 30; i++) {
            airbnbPage.checkIn.click();
            Thread.sleep(500);
            // has to match start i
            if (i == 1) {
                airbnbPage.nextMonthButton.click();
            }
            String checkinXpath = "//div[@data-testid='11-" + i + "-daytext']/..";
            String checkOutXpath = "//div[@data-testid='11-" + (i + 1) + "-daytext']/..";

            Thread.sleep(500);
            driver.findElement(By.xpath(checkinXpath)).click();
            Thread.sleep(500);


            driver.findElement(By.xpath(checkOutXpath)).click();
            Thread.sleep(500);
            airbnbPage.selectAdults("4");
            airbnbPage.searchBtn.click();
            Thread.sleep(500);
            utilities.switchWindow();
            Thread.sleep(1000);

            for (int k = 0; k < 3; k++) {

                // loop through houses
                for (int j = 0; j < airbnbPage.bedroomNumberList.size(); j++) {
                    try {

                        Map<String, String> houseDetails = new HashMap<>();
                        houseDetails.put("Date", "November " + i + " - " + (i + 1));
                        houseDetails.put("Bedroom Number", airbnbPage.bedroomNumberList.get(j).getText());
                        houseDetails.put("Price", airbnbPage.getHousePrice(airbnbPage.pricingTextList.get(j).getText()));
                        houseDetails.put("Occupancy", airbnbPage.ocupancyList.get(j).getText());
                        houseDetails.put("Number of beds", airbnbPage.numberOfBedsList.get(j).getText());
                        List<Map<String, String>> houseList = new ArrayList<>();
                        houseList.add(houseDetails);
                        if (!houseListMap.containsKey(airbnbPage.houseNameList.get(j).getText())) {
                            houseListMap.put(airbnbPage.houseNameList.get(j).getText(), houseList);
                        } else {
                            houseListMap.get(airbnbPage.houseNameList.get(j).getText()).add(houseDetails);
                        }

                    } catch (Exception e) {
                        System.out.println(" ----------------   House Skiped  " + ++n + "---------");
                    }
                }
                airbnbPage.nextPaqe.click();
                Thread.sleep(7000);
            }

            utilities.switchToDefaultWindow();

        }

        excelWriter.setWorkbook();


        excelWriter.writeExcelSheet(houseListMap, "November 1 - 30");

    }


}

