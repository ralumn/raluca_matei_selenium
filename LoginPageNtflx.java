package clase16.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageNtflx extends BasePageNtflx{

    public LoginPageNtflx(WebDriver driver){
        this.driver = driver;
    }

    public String getAllH1() {
        //OBTENER ELEMENTOS h1
        String textoBuscado="";
        String elemento ;
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));

        for (WebElement h1 : listaH1s) {
            elemento =h1.getText();
            if (elemento.contains("Iniciar sesión")){
                textoBuscado = elemento;
            }

        }
        return textoBuscado;
    }

    public void fillLoginFields()  {
        driver.findElement(By.id("id_userLoginId")).sendKeys("XXX");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");

      // WebElement elemento = driver.findElement(By.xpath("//*[@id='bxid_rememberMe_true']"));

        driver.findElement(By.xpath("//*[@data-uia='login-submit-button']")).click();
    }

    public Boolean marcarDesmarcarCajaRecuerdame(){
        WebElement elemento = driver.findElement(By.id("bxid_rememberMe_true"));
        Boolean isChecboxSelected=true;
        //desmarca el checkbox de recuerdame mediante JS, porque de otra manera no dejaba realizar click
        if (elemento.isSelected() && elemento.isEnabled()){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elemento);
            return isChecboxSelected = false;
        }else{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elemento);
            return isChecboxSelected = true;
        }
    }

    public String getErrorElement(){
        return driver.findElement(By.cssSelector(".inputError")).getText();
    }


}
