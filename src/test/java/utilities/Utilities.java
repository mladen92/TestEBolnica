package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Utilities {

    WebDriver driver = Driver.getDriver();


    public void switchWindow() {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handleToSwitch : handles) {
            if (!handleToSwitch.equals(currentHandle)) {
                driver.switchTo().window(handleToSwitch);
                return;
            }
        }
    }

    public void switchToDefaultWindow() {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handleToSwitch : handles) {
            if (!handleToSwitch.equals(currentHandle)) {
                driver.close();
                driver.switchTo().window(handleToSwitch);
                return;
            }
        }
    }

    public Double getPrice(String price) {
        String r = "";
        for (int i = 0; i < price.length(); i++) {
            r = (Character.isDigit(price.charAt(i))) ? (r + price.charAt(i)) : (r + "");
        }
        return Double.parseDouble(r);
    }

}
