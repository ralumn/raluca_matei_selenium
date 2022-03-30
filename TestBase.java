package SimulacroExamen.Tests;

import SimulacroExamen.Pages.HomePageBooking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    protected HomePageBooking homePageBooking;
    private String url= "https://www.booking.com/";

    @BeforeMethod
    public void setup()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        homePageBooking = new HomePageBooking(driver);
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //  Thread.sleep(2000);
        //accept cookies
        homePageBooking.acceptCookies();

    }

    @AfterMethod
    public void driverClose(){
        driver.close();
    }
}