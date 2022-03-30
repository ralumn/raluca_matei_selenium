package SimulacroExamen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageBooking extends BasePage{

    public HomePageBooking(WebDriver driver){
        this.driver = driver;
    }

    public void acceptCookies(){
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public SignUpPage goToLogin(){
        driver.findElement(By.linkText("Inicia sesión")).click();
        SignUpPage nextpage = new SignUpPage(driver);
        return nextpage;
    }

    public String getAllH2() {
        //OBTENER ELEMENTOS h2
        String textoBuscado="";
        String elemento ;
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));

        for (WebElement h2 : listaH2s) {
            elemento =h2.getText();
            if (elemento.contains("Conecta con gente viajera")){
                textoBuscado = elemento;
            }

        }
        return textoBuscado;
    }
}
