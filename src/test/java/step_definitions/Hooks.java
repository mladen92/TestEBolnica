package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {


    @Before
    public void setUp(){
      //  Driver.getDriver().get(ConfigurationReader.get("eBolnicaLocalUrl"));
        Driver.getDriver().manage().window().maximize();
    }



    @After
    public void tearDown(Scenario scenario){
//        if (scenario.isFailed()){
//            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
//        }
        Driver.closeDriver();
    }

}
