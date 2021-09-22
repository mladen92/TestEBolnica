package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadnikPage extends BasePage {


    @FindBy(id = "adresa")
    WebElement izaberiAdresu;
    @FindBy(name = "ime")
    WebElement ime;
    @FindBy(name = "prezime")
    WebElement prezime;
    @FindBy(id = "adresa")
    WebElement adresa;
    @FindBy(id = "odeljenje")
    WebElement odeljenje;
    @FindBy(name = "spec")
    WebElement specijalizacija;
    @FindBy(name = "datZap")
    WebElement datum;
    @FindBy(name = "korisnickoIme")
    WebElement korisnickoIme;
    @FindBy(name = "lozinka")
    WebElement lozinka;
    @FindBy(id = "status")
    WebElement status;
    @FindBy(name = "potvrdi")
    WebElement potvrdi;
    @FindBy(xpath = "//div[contains(text(), 'dodat radnik')]")
    WebElement uspesnoDodatRadnik;
    @FindBy(xpath = "//tbody/tr")
    List<WebElement> listaKreiranihRadnika;


    public void klikniNaIzaberiAdresu() {
        izaberiAdresu.click();
    }

    public void klikniNaPotvrdi() {
        potvrdi.click();
    }

    public void upisiIme(String ime) {
        this.ime.sendKeys(ime);
    }

    public void upisiPrezime(String prezime) {
        this.prezime.sendKeys(prezime);
    }

    public void upisiSpecijalizaciju(String specijalizacija) {
        this.specijalizacija.sendKeys(specijalizacija);
    }

    public void upisiDatum(String datum) {
        this.datum.sendKeys(datum);
    }

    public void upisiaKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.sendKeys(korisnickoIme);
    }

    public void upisiLozinku(String lozinka) {
        this.lozinka.sendKeys(lozinka);
    }

    public void izaberiStatus(String status) {
        Select select = new Select(this.status);
        select.selectByVisibleText(status);
    }

    public void izaberiAdresu(String adresa) {
        Select select = new Select(this.adresa);
        select.selectByVisibleText(adresa);
    }

    public void izaberiOdeljenje(String odeljenje) {
        Select select = new Select(this.odeljenje);
        select.selectByVisibleText(odeljenje);
    }

    public List<String> getListuAdresa() {
        List<String> listaAdresa = new ArrayList<>();
        Select select = new Select(izaberiAdresu);
        List<WebElement> adreseElementi = select.getOptions();
        for (WebElement each : adreseElementi) {
            listaAdresa.add(each.getText().trim());
        }
        return listaAdresa;
    }

    public boolean uspesnoDodatRadnikJeVidljiv() {
        return uspesnoDodatRadnik.isDisplayed();
    }

    public List<String> getPoslednjiRadnikInfo() {
        List<String> poslednjiRadnikInfo = new ArrayList<>();
        int index = listaKreiranihRadnika.size();
        System.out.println("index " + index);
        List<WebElement> poslednjiRadnik = driver.findElements(By.xpath("//tbody/tr[" + index + "]/td"));
        System.out.println("poslednjiRadnik " + poslednjiRadnik.size());
        for (int i = 0; i < poslednjiRadnik.size(); i++) {
            poslednjiRadnikInfo.add(poslednjiRadnik.get(i).getText());
        }
        return poslednjiRadnikInfo;
    }
}
