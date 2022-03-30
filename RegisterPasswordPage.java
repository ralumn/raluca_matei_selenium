package SimulacroExamen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPasswordPage extends BasePage{

    public RegisterPasswordPage (WebDriver driver){
        this.driver = driver;
    }
    public void setPassword(String password){
        driver.findElement(By.id("new_password")).sendKeys(password);
    }
    public void setConfirmPassword(String confirmedPassword){
        driver.findElement(By.id("confirmed_password")).sendKeys(confirmedPassword);
    }

    public List<WebElement> errorsPassword(){
        //driver.findElement(By.id("new_password-note"));

        List<WebElement> errores = driver.findElements(By.id("new_password-note"));

        return errores;
    }

    public void createAccountButton(){
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }



}
