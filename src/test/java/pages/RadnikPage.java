package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RadnikPage extends BasePage {


    @FindBy(id = "adresa")
    WebElement izaberiAdresu;

    public void klikniNaIzaberiAdresu(){
        izaberiAdresu.click();
    }
    public List<String> getListuAdresa (){
        List<String> listaAdresa = new ArrayList<>();
        Select select = new Select(izaberiAdresu);
        List<WebElement> adreseElementi = select.getOptions();
        for (WebElement each : adreseElementi) {
            listaAdresa.add(each.getText().trim());
        }
        return listaAdresa;
    }
}
