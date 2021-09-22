package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@class='sidebar']/div/a")
    List<WebElement> sidebarLista;


    public List<String> getSidebarListu() {
        List<String> actualSidebarLista = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(sidebarLista));
        for (WebElement element : sidebarLista) {
            actualSidebarLista.add(element.getText());
        }
        return actualSidebarLista;
    }

    public void klikniNaElementUSidebar(String target) {
        for (WebElement element : sidebarLista) {
            if (element.getText().contains(target)) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
        }
    }
}