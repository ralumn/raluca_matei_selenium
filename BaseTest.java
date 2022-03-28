package clase16.TestsBase;

import clase16.Pages.HomePageNtflxNetflix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
   protected HomePageNtflxNetflix homePageNetflix;
    private String URL= "https://www.netflix.com/es/";

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        homePageNetflix = new HomePageNtflxNetflix(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Thread.sleep(2000);
        homePageNetflix.rejectCookies();
    }

   // @AfterMethod
    public void driverClose(){
        driver.close();
    }
}
