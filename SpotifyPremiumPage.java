package clase15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyPremiumPage {
    public WebDriver driver;

    public SpotifyPremiumPage(WebDriver driver){
        this.driver = driver;
    }

    public String premiumPageTitle(){
        return driver.getTitle();
    }
    public String premiumPageURL(){
        return driver.getCurrentUrl();
    }

    //del ejercicio solo había un h1 en la página de Premium, así que solo encuentra y hace comprobación de uno
    public String searchAllH1(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    //creo método extra para encontrar los h2 ya que hay varios, y hace comprobaciones posteriormente de todos los mensajes
    public List<WebElement>  searchAllH2(){

        List<WebElement> h2 = driver.findElements(By.tagName("h2"));

        return h2;
    }
}
