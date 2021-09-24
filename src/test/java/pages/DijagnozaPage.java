package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DijagnozaPage extends BasePage {

    @FindBy(name = "naziv")
    WebElement nazivDijagnoze;

    @FindBy(name = "sifra")
    WebElement sifraDijagnoze;

    @FindBy(name = "opis")
    WebElement opisDijagnoze;

    @FindBy(name = "potvrdi")
    WebElement potvrdi;

    @FindBy(xpath = "//div[contains(text(), 'dodata dijagnoza')]")
    WebElement uspesnoDodataDijagnoza;

    @FindBy(xpath = "//div[contains(text(), 'Nije uspelo')]")
    WebElement nijeUspeloUpisivanje;

    public void upisiNazivDijagnoze(String dijagnoza) {
        this.nazivDijagnoze.sendKeys(dijagnoza);
    }

    public void upisiOpisDijagnoze(String opisDijagnoze) {
        this.opisDijagnoze.sendKeys(opisDijagnoze);
    }

    public void upisiSifraDijagnoze(String sifraDijagnoze) {
        this.sifraDijagnoze.sendKeys(sifraDijagnoze);
    }


    public void klikniPotvrdi() {
        this.potvrdi.click();
    }

    public boolean uspesnoDodataDijagnozaVidljiv() {
        return uspesnoDodataDijagnoza.isDisplayed();
    }

    public boolean nijeUspeloUpisivanjeDijagnozeJeVidljiv() {
        return nijeUspeloUpisivanje.isDisplayed();
    }
}
