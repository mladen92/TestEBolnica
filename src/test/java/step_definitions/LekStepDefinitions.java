package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.LekPage;


public class LekStepDefinitions {
LekPage lekPage = new LekPage();
    @When("unesem {string} u naziv leka")
    public void unesemUNazivLeka(String lek) {
        lekPage.upisiNazivLeka(lek);
    }

    @And("unesem {string} u unesi jedinicu mere")
    public void unesemUUnesiJedinicuMere(String jedMere) {
        lekPage.upisiJedinicaMere(jedMere);
    }

    @And("unesem {string} u unesi kolicinu")
    public void unesemUUnesiKolicinu(String kolicina) {
        lekPage.upisiKolicina(kolicina);
    }

    @And("unesem {string} u unesi supstancu")
    public void unesemUUnesiSupstancu(String supstanca) {
        lekPage.upisiSupstanca(supstanca);
    }

    @And("unesem {string} u unesi tip leka")
    public void unesemUUnesiTipLeka(String tip) {
        lekPage.upisiTip(tip);
    }

    @And("unesem {string} u unesi oblik leka")
    public void unesemUUnesiOnlikLeka(String oblik) {
        lekPage.upisiOblik(oblik);
    }

    @And("treba da vidim uspesno dodat lek")
    public void trebaDaVidimUspesnoDodatLek() {
       Assert.assertTrue(lekPage.uspesnoDodatLekJeVidljiv());
    }

    @And("treba da vidim Nije uspelo upisivanje leka")
    public void trebaDaVidimNijeUspeloUpisivanjeLeka() {
        Assert.assertTrue(lekPage.nijeUspeloUpisivanjeLekaJeVidljiv());
    }
}



