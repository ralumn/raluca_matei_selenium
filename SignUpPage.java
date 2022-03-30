package SimulacroExamen.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage extends BasePage{
    public Faker faker = new Faker();

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void mail (){
        //en vez de usar un faker uso un correo inventado, ya que me he encontrado algun correo generado por faker dado de alta
        //driver.findElement(By.id("username")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("username")).sendKeys("testbookingprueba@gmail.com");
    }
    public RegisterPasswordPage submitButton(){
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        RegisterPasswordPage nextpage = new RegisterPasswordPage(driver);
        return nextpage;
    }


}
