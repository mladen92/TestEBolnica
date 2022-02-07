package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class BrowserUtility {
    WebDriver driver;

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void openAnotherTab() {
      driver.switchTo().newWindow(WindowType.TAB);
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
}
