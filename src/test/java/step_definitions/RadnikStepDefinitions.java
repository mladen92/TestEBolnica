package step_definitions;

import cucumber.api.java.en.And;
import pages.RadnikPage;

public class RadnikStepDefinitions {
     RadnikPage radnikPage = new RadnikPage();

    @And("kliknem na izaberi adresu u Dodaj radnika")
    public void kliknemNaIzaberiAdresuUDodajRadnika() {
        radnikPage.klikniNaIzaberiAdresu();

    }
}
