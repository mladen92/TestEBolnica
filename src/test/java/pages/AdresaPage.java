package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdresaPage extends BasePage {

    @FindBy(name = "grad")
    WebElement unesiGrad;

    @FindBy(name = "ulica")
    WebElement unesiUlicu;

    @FindBy(name = "broj")
    WebElement unesiBroj;

    @FindBy(name = "pb")
    WebElement unesiPostanskiBroj;

    @FindBy(name = "potvrdi")
    WebElement potvrdi;

    @FindBy(xpath = "//div[@role='alert' and contains (text(),'dodata adresa')]")
    WebElement uspesnoDodataAdresa;

    public void upisiGrad (String grad){
        unesiGrad.sendKeys(grad);
    }

    public void upisiUlicu (String ulica) {
        unesiUlicu.sendKeys(ulica);
    }
    public void upisiBroj (String brojulice) {
        unesiBroj.sendKeys(brojulice);
    }
    public void upisiPostanskiBroj (String postanskiBroj) {
        unesiPostanskiBroj.sendKeys(postanskiBroj);
    }
    public void klikniPotvrdi () {
        wait.until(ExpectedConditions.elementToBeClickable(potvrdi));
        potvrdi.click();
    }
    public Boolean uspesnoDodataAdresaJeVidljiv (){
        return uspesnoDodataAdresa.isDisplayed();
    }
}
