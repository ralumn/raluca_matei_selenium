package clase15.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SpotifySignupPage {
    public WebDriver driver;
    public Faker faker = new Faker();

    public SpotifySignupPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillMail(String mail, String confirmmail){
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(mail);
        driver.findElement(By.cssSelector("[name='confirm']")).sendKeys(confirmmail);
    }

    public void fillPassword(){
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(faker.internet().password());
    }

    public void fillDisplayName(){
        driver.findElement(By.xpath("//*[@id='displayname']")).sendKeys(faker.name().firstName());
    }

    public void fillBirthdayDate(){

        driver.findElement(By.xpath("//*[@id='day']")).sendKeys("15");
        driver.findElement(By.xpath("//*[@id='year']")).sendKeys("1990");
        WebElement industryElement = driver.findElement(By.xpath("//select[@id ='month']"));
        Select industrySelect = new Select (industryElement);
        industrySelect.selectByValue("02");

    }

    public void selectSex(){
        driver.findElement(By.xpath("//*[@for='gender_option_female']")).click();
    }

   /* public String invalidMailMessage(){
       String errorMessage = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']")).getText();
        List<WebElement> links = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        System.out.println(links);
       return errorMessage;
    }*/

    public List<WebElement> invalidFieldsErrors(){
        List<WebElement> links = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));

        return links;
    }

    public void submitButtonClick(){
        driver.findElement(By.tagName("button")).click();
    }

    public String signupPageTitle(){
        return driver.getTitle();
    }

    public String signupPageURL(){
        return driver.getCurrentUrl();
    }

}
