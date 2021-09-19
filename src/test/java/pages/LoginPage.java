package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Encrypt;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    WebElement korisničkoIme;
    @FindBy(name = "password")
    WebElement lozinka;
    @FindBy(xpath = "//div[@class='login']//button")
    WebElement prijaviSe;
    @FindBy(id = "logUser")
    WebElement ulogovaniKorisnik;
    @FindBy(xpath = "//span[@id='logUser']/button")
    WebElement odjava;
    @FindBy(className = "wrong-data")
    WebElement pogresniKredencijali;


    public void ulogujSe(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(korisničkoIme));
        korisničkoIme.sendKeys(username);
        lozinka.sendKeys(password);
        prijaviSe.click();
    }

    public String getPrijavljeniKorisnik() {
        String str = ulogovaniKorisnik.getText().replace("Odjava", "");
        return str.substring(str.indexOf(':') + 1).trim();
    }

    public void odjaviSe() {
        odjava.click();
    }

    public boolean korisnickoImeJeVidljivo() {
        return korisničkoIme.isDisplayed();
    }

    public boolean pogresniKredencijaliJeVidljivo() {
        return pogresniKredencijali.isDisplayed();
    }

}
