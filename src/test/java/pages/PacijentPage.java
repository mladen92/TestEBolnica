package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PacijentPage extends BasePage {


    @FindBy(id = "adresa")
    WebElement izaberiAdresu;
    @FindBy(name = "ime")
    WebElement ime;
    @FindBy(name = "prezime")
    WebElement prezime;
    @FindBy(id = "pol")
    WebElement izaberiPol;
    @FindBy(name = "jmbg")
    WebElement jmbg;
    @FindBy(name = "lbo")
    WebElement lbo;
    @FindBy(name = "brtel")
    WebElement brojTelefona;
    @FindBy(id = "vakcinacija")
    WebElement izaberiVakcinaciju;
    @FindBy(name = "alergije")
    WebElement alergije;
    @FindBy(id = "krvnaGrupa")
    WebElement krvnaGrupa;
    @FindBy(id = "covidTest")
    WebElement covidTest;
    @FindBy(name = "potvrdi")
    WebElement potvrdi;
    @FindBy(xpath = "//div[contains(text(), 'dodat pacijent')]")
    WebElement uspesnoDodatPacijent;
    @FindBy(xpath = "//tbody/tr")
    List<WebElement> listaKreiranihPacijenata;
    @FindBy(xpath = "//div[@role='alert' and contains (text(),'Niste uneli')]")
    WebElement nisteUneliSvePodatke;



    public void klikniNaPotvrdi() {
        potvrdi.click();
    }

    public void upisiIme(String ime) {
        this.ime.sendKeys(ime);
    }

    public void upisiPrezime(String prezime) {
        this.prezime.sendKeys(prezime);
    }

    public void upisiJMBG(String jmbg) {
        this.jmbg.sendKeys(jmbg);
    }

    public void upisiLbo(String lbo) {
        this.lbo.sendKeys(lbo);
    }

    public void upisiBrojTelefona(String broj) {
        this.brojTelefona.sendKeys(broj);
    }

    public void upisiAlergije(String alergije) {
        this.alergije.sendKeys(alergije);
    }


    public void izaberiAdresu(String adresa) {
        Select select = new Select(this.izaberiAdresu);
        select.selectByVisibleText(adresa);
    }

    public void izaberiKrvnuGrupu(String krvnaGrupa) {
        Select select = new Select(this.krvnaGrupa);
        select.selectByVisibleText(krvnaGrupa);
    }

    public void izaberiCoviDTest(String covidTest) {
        Select select = new Select(this.covidTest);
        select.selectByVisibleText(covidTest);
    }

    public void izaberiPol(String pol) {
        Select select = new Select(this.izaberiPol);
        select.selectByVisibleText(pol);
    }

    public void izaberiVakcinaciju(String vakcina) {
        Select select = new Select(this.izaberiVakcinaciju);
        select.selectByVisibleText(vakcina);
    }


    public boolean uspesnoDodatPacijentJeVidljiv() {
        return uspesnoDodatPacijent.isDisplayed();
    }


    public List<String> getPoslednjiPacijentInfo() {
        List<String> poslednjiPacijentInfo = new ArrayList<>();
        int index = listaKreiranihPacijenata.size();
        System.out.println("index " + index);
        List<WebElement> poslednjiPacijent = driver.findElements(By.xpath("//tbody/tr[" + index + "]/td"));
        System.out.println("poslednjiRadnik " + poslednjiPacijent.size());
        for (int i = 0; i < poslednjiPacijent.size(); i++) {
            poslednjiPacijentInfo.add(poslednjiPacijent.get(i).getText());
        }
        return poslednjiPacijentInfo;
    }
}
