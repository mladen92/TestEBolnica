package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.DijagnozaPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.Encrypt;

import java.util.List;

public class StepDefinitions {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    DijagnozaPage dijagnozaPage = new DijagnozaPage();

    @When("se ulogujem u eBolnica sa korisnickim imenom {string} i lozinkom {string}")
    public void ulogujSe(String korisnickoIme, String lozinka) throws Exception {
        Encrypt encrypt = new Encrypt();
        loginPage.ulogujSe(korisnickoIme, encrypt.decrypt(lozinka));

    }

    @Then("title na stranici treba da bude {string}")
    public void titleNaStraniciTrebaDaBude(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @And("prijavljen korisnik treba da bude {string}")
    public void prijavljenKorisnikTrebaDaBude(String korisnikovoIme) {
        Assert.assertEquals(korisnikovoIme, loginPage.getPrijavljeniKorisnik());
    }

    @When("kliknem na Odjava")
    public void kliknemNaOdjava() {
        loginPage.odjaviSe();
    }

    @Then("treba da vidim Korisnicko Ime")
    public void trebaDaVidimKorisnickoIme() {
        Assert.assertTrue(loginPage.korisnickoImeJeVidljivo());
    }

    @When("se ulogujem u eBolnica sa pogresnim korisnickim imenom {string} i lozinkom {string}")
    public void seUlogujemUEBolnicaSaPogresnimKorisnickimImenomILozinkom(String korisnickoIme, String lozinka) {
        loginPage.ulogujSe(korisnickoIme, lozinka);
    }

    @Then("treba da vidim Pogresni Kredencijali")
    public void trebaDaVidimPogresniKredencijali() {
        Assert.assertTrue(loginPage.pogresniKredencijaliJeVidljivo());
    }

    @Then("treba da vidim sledece stavke u sidebar")
    public void trebaDaVidimSledeceStavkeUSidebar(List<String> expectedSidebar) {
        List<String> actualSidebar = dashboardPage.getSidebarListu();
        Assert.assertEquals(expectedSidebar, actualSidebar);
    }

    @When("kliknem na {string} u sidebar")
    public void kliknemNaUSidebar(String target) {
        dashboardPage.klikniNaElementUSidebar(target);
    }

    @When("unesem {string} u naziv dijagnoza")
    public void unesemUNazivDijagnoza(String nazivDijagnoze) {
        dijagnozaPage.upisiNazivDijagnoze(nazivDijagnoze);
    }

    @And("unesem {string} u unesi sifru dijagnoze")
    public void unesemUUnesiSifruDijagnoze(String sifraDijagnoze) {
        dijagnozaPage.upisiSifraDijagnoze(sifraDijagnoze);
    }

    @And("unesem {string} u unesi opis")
    public void unesemUUnesiOpis(String opisDijagnoze) {
        dijagnozaPage.upisiOpisDijagnoze(opisDijagnoze);
    }

    @Then("kliknem na potvrdi unos dijagnoze")
    public void kliknemNaPotvrdiUnosDijagnoze() {
        dijagnozaPage.klikniPotvrdi();
    }

    @And("treba da vidim uspesno dodata dijagnoza")
    public void trebaDaVidimUspesnoDodataDijagnoza() {
        Assert.assertTrue(dijagnozaPage.uspesnoDodataDijagnozaVidljiv());
    }

    @And("treba da vidim Nije uspelo upisivanje dijagnoze")
    public void trebaDaVidimNijeUspeloUpisivanjeDijagnoze() {
        Assert.assertTrue(dijagnozaPage.nijeUspeloUpisivanjeDijagnozeJeVidljiv());
    }
}