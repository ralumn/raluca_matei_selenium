package clase15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SpotifyHomePage {
    public WebDriver driver;

    public SpotifyHomePage(WebDriver driver){
        this.driver = driver;
    }

    public SpotifySignupPage registrationButton()  {

        driver.findElement(By.linkText("Registrarse")).click();
        SpotifySignupPage nextpage = new SpotifySignupPage(driver);
        return nextpage;
    }

    public SpotifyPremiumPage PremiumButton(){

        driver.findElement(By.linkText("Premium")).click();
        SpotifyPremiumPage nextpage = new SpotifyPremiumPage(driver);
        return nextpage;
    }

    public String homePageTitle(){
        return driver.getTitle();
    }
    public String homePageURL(){
        return driver.getCurrentUrl();
    }
}
