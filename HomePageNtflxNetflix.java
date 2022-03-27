package clase16.Pages;

import clase15.Pages.SpotifySignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageNtflxNetflix extends BasePageNtflx {


    public HomePageNtflxNetflix(WebDriver driver){
        this.driver = driver;
    }

    public LoginPageNtflx iniciarSesion(){
        driver.findElement(By.linkText("Iniciar sesión")).click();
        LoginPageNtflx nextpage = new LoginPageNtflx(driver);
        return nextpage;
    }

    public void Rejectcookies(){
        driver.findElement(By.cssSelector(".btn-reject")).click();
    }

}
