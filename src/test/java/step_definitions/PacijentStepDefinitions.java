package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.PacijentPage;

import java.util.Arrays;
import java.util.List;


public class PacijentStepDefinitions {
    PacijentPage pacijentPage = new PacijentPage();

    @When("unesem {string} u unesite ime pacijenta")
    public void unesemUUnesiteImePacijenta(String ime) {
        pacijentPage.upisiIme(ime);
    }

    @And("unesem {string} u unesite prezime pacijenta")
    public void unesemUUnesitePrezimePacijenta(String prezime) {
        pacijentPage.upisiPrezime(prezime);
    }

    @And("izaberem {string} iz izaberite pol")
    public void izaberemIzIzaberitePol(String pol) {
        pacijentPage.izaberiPol(pol);
    }

    @And("unesem {string} u unesite jmbg")
    public void unesemUUnesiteJmbg(String jmbg) {
        pacijentPage.upisiJMBG(jmbg);
    }

    @And("unesem {string} u unesite lbo")
    public void unesemUUnesiteLbo(String lbo) {
        pacijentPage.upisiLbo(lbo);
    }

    @And("unesem {string} u unesite broj telefona")
    public void unesemUUnesiteBrojTelefona(String broj) {
        pacijentPage.upisiBrojTelefona(broj);
    }

    @And("izaberem {string} iz izaberite adresu pacijenta")
    public void izaberemIzIzaberiteAdresuPacijenta(String adresa) {
        pacijentPage.izaberiAdresu(adresa);
    }

    @And("izaberem {string} iz da li je pacijent vakcinisan")
    public void izaberemIzDaLiJePacijentVakcinisan(String vakcinisan) {
        pacijentPage.izaberiVakcinaciju(vakcinisan);
    }

    @And("unesem {string} u unesite alergije")
    public void unesemUUnesiteAlergije(String alergije) {
        pacijentPage.upisiAlergije(alergije);
    }

    @And("izaberem {string} iz izaberite krvnu grupu")
    public void izaberemIzIzaberiteKrvnuGrupu(String krvnaGrupa) {
        pacijentPage.izaberiKrvnuGrupu(krvnaGrupa);
    }

    @And("izaberem {string} iz opcije covid testa")
    public void izaberemIzOpcijeCovidTesta(String covidTest) {
        pacijentPage.izaberiCoviDTest(covidTest);
    }

    @Then("kliknem na potvrdi unos pacijenta")
    public void kliknemNaPotvrdiUnosPacijenta() {
        pacijentPage.klikniNaPotvrdi();
    }

    @And("treba da vidim uspesno dodat Pacijent")
    public void trebaDaVidimUspesnoDodatPacijent() {
        Assert.assertTrue(pacijentPage.uspesnoDodatPacijentJeVidljiv());
    }

    @Then("verifikujemo da je poslednji pacijent {string}")
    public void verifikujemoDaJePoslednjiPacijent(String expectedPodaciOpacijentu) {
        List<String> podaciOPacijentu = Arrays.asList(expectedPodaciOpacijentu.split(", "));
        List<String> actualPodaciOPacijentu = pacijentPage.getPoslednjiPacijentInfo();
        for (int i = 0; i < podaciOPacijentu.size(); i++) {
            Assert.assertEquals(podaciOPacijentu.get(i), actualPodaciOPacijentu.get(i));
        }
    }

}
