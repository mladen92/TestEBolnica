package q1_amazon_test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.BrowserUtility;
import utilities.CSVUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {
    WebDriverWait wait;
    BrowserUtility browserUtility;
    AmazonPage amazonPage;
    CSVUtilities csvUtilities;

    @BeforeTest
    public void setUp() {
        wait = new WebDriverWait(Driver.getDriver(), 20);
        amazonPage = new AmazonPage();
        browserUtility = new BrowserUtility(Driver.getDriver());
        csvUtilities = new CSVUtilities();

        Driver.getDriver().get(ConfigurationReader.get("amazonURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPage.amazonLogo));

    }

    @Test
    public void q1_TC_Bluetooth_Headset() throws IOException {
        // Enter product in search box
        String itemToSearch = "Bluetooth Headset";
        amazonPage.searchItem(itemToSearch);
        List<Product> products = new ArrayList<>();


        List<WebElement> listOfAllLinks = amazonPage.productLinkList;

        for (int i = 0; i < listOfAllLinks.size(); i++) {
            // open each product on new window and grab data
            String itemUrl = listOfAllLinks.get(i).getAttribute("href");
            browserUtility.openAnotherTab();
            Driver.getDriver().get(itemUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPage.amazonLogo));

            // store collected data in Product object and add to list of products
            Product product = new Product();
            product.setName(amazonPage.productName.getText());
            product.setDescription(amazonPage.productDescription.getText());
            product.setRating(amazonPage.getProductRating());
            product.setPrice(amazonPage.getProductPrice());
            products.add(product);
            //  close current window and switch to the original one with all product results
            browserUtility.switchToDefaultWindow();

        }
        // sort by price and print two top products
        Collections.sort(products, (Product a1, Product a2) -> a2.getPrice().compareTo(a1.getPrice()));
        System.out.println(products.get(0).toString());
        System.out.println(products.get(1).toString());

        // store everything to csv file
        File file = new File("src/test/java/q1_amazon_test/" + itemToSearch + ".csv");
        csvUtilities.writeAmazonProducts(products, file.getPath());
    }

    @Test
    public void q1_TC_34_Inch_LED_Monitor() throws IOException {
        // Enter product in search box
        String itemToSearch = "34 inch LED monitor";
        amazonPage.searchItem(itemToSearch);
        List<Product> products = new ArrayList<>();


        List<WebElement> listOfAllLinks = amazonPage.productLinkList;

        for (int i = 0; i < listOfAllLinks.size(); i++) {
            // open each product on new window and grab data
            String itemUrl = listOfAllLinks.get(i).getAttribute("href");
            browserUtility.openAnotherTab();
            Driver.getDriver().get(itemUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPage.amazonLogo));

            // store collected data in Product object and add to list of products
            Product product = new Product();
            product.setName(amazonPage.productName.getText());
            product.setDescription(amazonPage.productDescription.getText());
            product.setRating(amazonPage.getProductRating());
            product.setPrice(amazonPage.getProductPrice());
            products.add(product);
            //  close current window and switch to the original one with all product results
            browserUtility.switchToDefaultWindow();

        }
        // sort by price and print two top products
        Collections.sort(products, (Product a1, Product a2) -> a2.getPrice().compareTo(a1.getPrice()));
        System.out.println(products.get(0).toString());
        System.out.println(products.get(1).toString());

        // store everything to csv file
        File file = new File("src/test/java/q1_amazon_test/" + itemToSearch + ".csv");
        csvUtilities.writeAmazonProducts(products, file.getPath());
    }

    @Test
    public void q1_TC_USB_C_Dock() throws IOException {
        // Enter product in search box
        String itemToSearch = "USB c dock";
        amazonPage.searchItem(itemToSearch);
        List<Product> products = new ArrayList<>();


        List<WebElement> listOfAllLinks = amazonPage.productLinkList;

        for (int i = 0; i < listOfAllLinks.size(); i++) {
            // open each product on new window and grab data
            String itemUrl = listOfAllLinks.get(i).getAttribute("href");
            browserUtility.openAnotherTab();
            Driver.getDriver().get(itemUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPage.amazonLogo));

            // store collected data in Product object and add to list of products
            Product product = new Product();
            product.setName(amazonPage.productName.getText());
            product.setDescription(amazonPage.productDescription.getText());
            product.setRating(amazonPage.getProductRating());
            product.setPrice(amazonPage.getProductPrice());
            products.add(product);
            //  close current window and switch to the original one with all product results
            browserUtility.switchToDefaultWindow();

        }
        // sort by price and print two top products
        Collections.sort(products, (Product a1, Product a2) -> a2.getPrice().compareTo(a1.getPrice()));
        System.out.println(products.get(0).toString());
        System.out.println(products.get(1).toString());

        // store everything to csv file
        File file = new File("src/test/java/q1_amazon_test/" + itemToSearch + ".csv");
        csvUtilities.writeAmazonProducts(products, file.getPath());
    }

    @Test
    public void q1_TC_Smart_Watch() throws IOException {
        // Enter product in search box
        String itemToSearch = "Smart watch";
        amazonPage.searchItem(itemToSearch);
        List<Product> products = new ArrayList<>();


        List<WebElement> listOfAllLinks = amazonPage.productLinkList;

        for (int i = 0; i < listOfAllLinks.size(); i++) {
            // open each product on new window and grab data
            String itemUrl = listOfAllLinks.get(i).getAttribute("href");
            browserUtility.openAnotherTab();
            Driver.getDriver().get(itemUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPage.amazonLogo));

            // store collected data in Product object and add to list of products
            Product product = new Product();
            product.setName(amazonPage.productName.getText());
            product.setDescription(amazonPage.productDescription.getText());
            product.setRating(amazonPage.getProductRating());
            product.setPrice(amazonPage.getProductPrice());
            products.add(product);
            //  close current window and switch to the original one with all product results
            browserUtility.switchToDefaultWindow();

        }
        // sort by price and print two top products
        Collections.sort(products, (Product a1, Product a2) -> a2.getPrice().compareTo(a1.getPrice()));
        System.out.println(products.get(0).toString());
        System.out.println(products.get(1).toString());

        // store everything to csv file
        File file = new File("src/test/java/q1_amazon_test/" + itemToSearch + ".csv");
        csvUtilities.writeAmazonProducts(products, file.getPath());
    }


    @AfterTest
    public void turnDown() {
        Driver.closeDriver();
    }

}
