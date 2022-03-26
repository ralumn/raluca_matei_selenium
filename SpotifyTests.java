package clase15.TestsPackage;

import clase15.Pages.SpotifyHomePage;
import clase15.Pages.SpotifyPremiumPage;
import clase15.Pages.SpotifySignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTests {
    WebDriver driver;
    private String spotifyURL= "https://www.spotify.com/es/";
    private  SpotifyHomePage homePageSpotify;
    private SpotifySignupPage signup;


    @BeforeMethod
    public void setup()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(spotifyURL);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        //accept cookies
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

    }

    @Test
    //test extra donde todos los datos son correctos, sin hacer click en botón de sumbit
    public void testSignupCorrect() {
        homePageSpotify = new SpotifyHomePage(driver);
        signup= homePageSpotify.registrationButton();
       // signup = new SpotifySignupPage(driver);
        signup.fillMail("test@gmail.com","test@gmail.com");
        signup.fillDisplayName();
        signup.fillPassword();
        signup.fillBirthdayDate();
        signup.selectSex();
    }

    @Test
    public void testIncorrectMailFormat(){

        homePageSpotify = new SpotifyHomePage(driver);
        Assert.assertEquals(homePageSpotify.homePageURL(),"https://www.spotify.com/es/");
        Assert.assertEquals(homePageSpotify.homePageTitle(),"Escuchar lo es todo - Spotify");

        signup = homePageSpotify.registrationButton();

        signup.fillMail("@@@.com","@@@.com");
       // String invalidMail = signup.invalidMailMessage();
       // Assert.assertEquals(invalidMail,"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
        //System.out.println(invalidMail);

        //hace click en el botón del sumbit para que salgan todos los errores y posteriormente se validen
        signup.submitButtonClick();

        List<WebElement> links = signup.invalidFieldsErrors();
         for(WebElement elemento : links){
           String texto= elemento.getText();
            if(texto.contains("correo")){
                Assert.assertEquals(texto,"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
            }else if (texto.contains("contraseña")){
                Assert.assertEquals(texto,"Es necesario que indiques una contraseña.");
            }else if (texto.contains("nombre")){
                Assert.assertEquals(texto,"Indica un nombre para tu perfil.");
            }else if (texto.contains("día")){
                Assert.assertEquals(texto,"Indica un día válido del mes.");
            }else if (texto.contains("nacimiento")){
                Assert.assertEquals(texto,"Selecciona tu mes de nacimiento.");
            }else if (texto.contains("año")){
                Assert.assertEquals(texto,"Indica un año válido.");
            }else if (texto.contains("género")){
                Assert.assertEquals(texto,"Selecciona tu género.");
            }
    }

        Assert.assertEquals(signup.signupPageTitle(),"Registrarte - Spotify");
        Assert.assertEquals(signup.signupPageURL(),"https://www.spotify.com/es/signup");
    }

    @Test
    public void testPremium() {
        homePageSpotify = new SpotifyHomePage(driver);
        SpotifyPremiumPage premium = homePageSpotify.PremiumButton();
        String h1=premium.searchAllH1();
        Assert.assertEquals(h1,"Pásate a Premium gratis por un mes");

        //EXTRA: comprobaciones de los h2 de la página
        List<WebElement> h2 = premium.searchAllH2();
        for(WebElement elemento : h2){
            String textoh2= elemento.getText();
            if(textoh2.contains("pasarte")){
                Assert.assertEquals(textoh2,"¿Por qué pasarte a Premium?");
            }else if (textoh2.contains("Cancela")){
                Assert.assertEquals(textoh2,"Después, solo 9,99 €/mes. Cancela cuando quieras.");
            }else if (textoh2.contains("Elige")){
                Assert.assertEquals(textoh2,"Elige tu Premium");
            }

        }

    }

    @AfterMethod
    public void driverClose(){
        driver.close();
    }

}
