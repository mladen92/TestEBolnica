package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LekPage extends BasePage {

    @FindBy(name = "naziv")
    WebElement nazivLeka;

    @FindBy(name = "jedMere")
    WebElement jedinicaMere;

    @FindBy(name = "kolicina")
    WebElement kolicina;

    @FindBy(name = "supstanca")
    WebElement supstanca;

    @FindBy(name = "tip")
    WebElement tip;

    @FindBy(name = "oblik")
    WebElement oblik;

    @FindBy(name = "potvrdi")
    WebElement potvrdi;

    @FindBy(xpath = "//div[contains(text(), 'dodat lek')]")
    WebElement uspesnoDodatLek;

    @FindBy(xpath = "//div[contains(text(), 'Nije uspelo')]")
    WebElement nijeUspeloUpisivanje;

    public void upisiNazivLeka(String nazivLeka) {
        this.nazivLeka.sendKeys(nazivLeka);
    }

    public void upisiJedinicaMere(String jedinicaMere) {
        this.jedinicaMere.sendKeys(jedinicaMere);
    }
    public void upisiKolicina(String kolicina) {
        this.kolicina.sendKeys(kolicina);
    }

    public void upisiSupstanca(String supstanca) {
        this.supstanca.sendKeys(supstanca);
    }

    public void upisiTip(String tip) {
        this.tip.sendKeys(tip);
    }

    public void upisiOblik(String oblik) {
        this.oblik.sendKeys(oblik);
    }

    public void klikniPotvrdi() {
        this.potvrdi.click();
    }
    public boolean uspesnoDodatLekJeVidljiv(){
        return uspesnoDodatLek.isDisplayed();
    }
    public boolean nijeUspeloUpisivanjeLekaJeVidljiv(){
        return nijeUspeloUpisivanje.isDisplayed();
    }
}
