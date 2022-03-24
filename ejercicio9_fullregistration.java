import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static java.sql.DriverManager.getDriver;

public class ejercicio9_fullregistration {

    
    WebDriver driver;
    String URL = "https://www.facebook.com/";

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        sleep(3000);
    }

    @Test
    public void fullRegistrationTest ()throws InterruptedException{
        //acepta banner cookies
        driver.findElement(By.cssSelector("button[title='Permitir cookies necesarias y opcionales']")).click();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        rellenaDatosFacebook(driver,"John", "Smith","555555555","123456789");
        setBirthdate(driver,"26","jun","1980");

        List <WebElement> listaSexo = driver.findElements(By.name("sex"));
        WebElement radioButtonSexo = listaSexo.get(1) ;
        radioButtonSexo.click();

    }

    private static void rellenaDatosFacebook (WebDriver driver, String nombre, String apellido, String telefono, String contras){

        driver.findElement(By.name("firstname")).sendKeys(nombre);
        driver.findElement(By.name("lastname")).sendKeys(apellido);
        driver.findElement(By.name("reg_email__")).sendKeys(telefono);
        driver.findElement(By.id("password_step_input")).sendKeys(contras);
    }

    private static void setBirthdate (WebDriver driver, String dia, String mes, String anio){
        WebElement dias = driver.findElement(By.name("birthday_day"));
        Select comboDias = new Select(dias);
        comboDias.selectByVisibleText(dia);

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText(mes);

        WebElement anios = driver.findElement(By.name("birthday_year"));
        Select comboAnio = new Select(anios);
        comboAnio.selectByValue(anio);
    }


}
