package clase16.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageNtflx extends BasePageNtflx{

    public LoginPageNtflx(WebDriver driver){
        this.driver = driver;
    }

    public String validateH1Texts(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    public void fillLoginFields()  {
        driver.findElement(By.id("id_userLoginId")).sendKeys("XXX");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");

      // WebElement elemento = driver.findElement(By.xpath("//*[@id='bxid_rememberMe_true']"));

        driver.findElement(By.xpath("//*[@data-uia='login-submit-button']")).click();
    }

    public void marcarDesmarcarCheckboxRecuerdame(){
        WebElement elemento = driver.findElement(By.id("bxid_rememberMe_true"));
        //desmarca el checkbox de recuerdame mediante JS, porque de otra manera no dejaba realizar click
        if (elemento.isSelected() && elemento.isEnabled()){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elemento);
        }else{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elemento);
        }
    }

    public String GetErrorElement(){
        return driver.findElement(By.cssSelector(".inputError")).getText();
    }


}
