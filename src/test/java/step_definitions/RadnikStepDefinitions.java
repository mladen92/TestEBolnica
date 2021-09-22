package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.RadnikPage;

import java.util.Arrays;
import java.util.List;

public class RadnikStepDefinitions {
     RadnikPage radnikPage = new RadnikPage();

    @And("kliknem na izaberi adresu u Dodaj radnika")
    public void kliknemNaIzaberiAdresuUDodajRadnika() {
        radnikPage.klikniNaIzaberiAdresu();

    }

    @When("unesem {string} u unesite ime radnika")
    public void unesemUUnesiteImeRadnika(String imeRadnika) {
        radnikPage.upisiIme(imeRadnika);
    }

    @And("unesem {string} u unesite prezime radnika")
    public void unesemUUnesitePrezimeRadnika(String prezimeRadnika) {
        radnikPage.upisiPrezime(prezimeRadnika);
    }

    @And("izaberem {string} iz izaberite adresu radnika")
    public void izaberemIzIzaberiteAdresuRadnika(String adresaRadnika) {
        radnikPage.izaberiAdresu(adresaRadnika);
    }

    @And("izaberem {string} iz izaberite odeljenje")
    public void izaberemIzIzaberiteOdeljenje(String odeljenje) {
        radnikPage.izaberiOdeljenje(odeljenje);
    }

    @And("unesem {string} u unesite specijalizaciju")
    public void unesemUUnesiteSpecijalizaciju(String specijalizacija) {
        radnikPage.upisiSpecijalizaciju(specijalizacija);
    }

    @And("unesem {string} u kalendar radnika")
    public void unesemUKalendarRadnika(String datum) {
        radnikPage.upisiDatum(datum);
    }

    @And("unesem {string} u unesite korisnicko ime")
    public void unesemUUnesiteKorisnickoIme(String korisnickoIme) {
        radnikPage.upisiaKorisnickoIme(korisnickoIme);
    }

    @And("unesem {string} u unesite lozinku")
    public void unesemUUnesiteLozinku(String lozinka) {
        radnikPage.upisiLozinku(lozinka);
    }

    @Then("kliknem na potvrdi unos radnika")
    public void kliknemNaPotvrdiUnosRadnika() {
        radnikPage.klikniNaPotvrdi();
    }

    @And("treba da vidim uspesno dodat radnik")
    public void trebaDaVidimUspesnoDodatRadnik() {
        Assert.assertTrue(radnikPage.uspesnoDodatRadnikJeVidljiv());
    }

    @Then("verifikujemo da je poslednji radnik {string}")
    public void verifikujemoDaJePoslednjiRadnik(String expectedPodaciOradniku) {
        List<String> podaciORadniku = Arrays.asList(expectedPodaciOradniku.split(", "));
        List<String> actualPodaciORadniku = radnikPage.getPoslednjiRadnikInfo();
        for (int i = 0; i < podaciORadniku.size(); i++) {
            Assert.assertEquals(podaciORadniku.get(i), actualPodaciORadniku.get(i));
        }

    }

    @And("izaberem {string} iz izaberite status")
    public void izaberemIzIzaberiteStatus(String status) {
        radnikPage.izaberiStatus(status);
    }
}
