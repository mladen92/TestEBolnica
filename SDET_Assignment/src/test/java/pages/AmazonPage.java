package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AmazonPage extends BasePage {

    public By amazonLogo = By.id("nav-logo-sprites");

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;

    @FindBy(id = "productTitle")
    public WebElement productName;

    @FindBy(id = "featurebullets_feature_div")
    public WebElement productDescription;

    @FindBy(id ="acrPopover")
    public WebElement productRating;

    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    public WebElement productPrice;


    @FindBy(xpath = "//div[@class='a-section']//h2/a")
   public List<WebElement> productLinkList;

    public void searchItem(String searchProduct) {
        searchBox.clear();
        searchBox.sendKeys(searchProduct);
        searchSubmitButton.click();
        wait.until(ExpectedConditions.titleContains(searchProduct));
    }

    public double getProductRating(){
        // getting string from element in Format 'n.n out of n stars' and convert to double for easier manipulation
        // if there is no review set as 0.00
        try {
            String productRating = this.productRating.getAttribute("title");
            return Double.parseDouble(productRating.substring(0,productRating.indexOf(' ')));
        }catch (RuntimeException e){
            return 0.00;
        }
    }
    public double getProductPrice(){
        // getting string from element in Format '$nn.nn' and convert to double for easier sort
        String productPrice =  this.productPrice.getAttribute("innerHTML");

        return Double.parseDouble(productPrice.replace("\n", ".").replace("$","").replace(",",""));
    }
}
