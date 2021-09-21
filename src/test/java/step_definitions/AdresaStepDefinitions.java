package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AdresaPage;
import pages.RadnikPage;

import java.util.List;

public class AdresaStepDefinitions {

    AdresaPage adresaPage = new AdresaPage();
    RadnikPage radnikPage = new RadnikPage();

    @When("unesem {string} u unesi grad")
    public void unesemUUnesiGrad(String grad) {
        adresaPage.upisiGrad(grad);
    }

    @And("unesem {string} u unesi ulicu")
    public void unesemUUnesiUlicu(String ulicu) {
        adresaPage.upisiUlicu(ulicu);
    }

    @And("unesem {string} u unesi broj ulice")
    public void unesemUUnesiBroj(String broj) {
        adresaPage.upisiBroj(broj);
    }

    @And("unesem {string} u unesi postanski broj")
    public void unesemUUnesiPostanskiBroj(String postanskiBroj) {
        adresaPage.upisiPostanskiBroj(postanskiBroj);
    }

    @Then("kliknem na potvrdi unos adrese")
    public void kliknemNaPotvrdiUnosAdrese() {
        adresaPage.klikniPotvrdi();
    }

    @And("treba da vidim uspesno dodata adresa")
    public void trebaDaVidimUspesnoDodataAdresa() {
        Assert.assertTrue("Uspesno kreirana nova adresa alert je vidiljiv", adresaPage.uspesnoDodataAdresaJeVidljiv());
    }

    @Then("verifikujemo da je poslednja adresa {string}")
    public void verifikujemoDaJePoslednjaAdresa(String expectedAdresa) {
        List<String> listaAdresa = radnikPage.getListuAdresa();
        String actual = listaAdresa.get(listaAdresa.size() - 1);
        Assert.assertEquals(expectedAdresa, actual);

    }


    @And("treba da vidim Niste Uneli sve podatke")
    public void trebaDaVidimNisteUneliSvePodatke() {
        Assert.assertTrue("Niste uneli sve podatke alert je vidiljiv", adresaPage.nisteUneliSvePodatkeJeVidljiv());
    }

    @Then("verifikujemo da {string} adresa nije dodata")
    public void verifikujemoDaAdresaNijeDodata(String adresa) {
        List<String> listaAdresa = radnikPage.getListuAdresa();
        for (String actualAdresa : listaAdresa) {
            Assert.assertNotEquals(adresa, actualAdresa);
        }
    }
}



