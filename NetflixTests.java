package clase16.Tests;

import clase15.Pages.SpotifyHomePage;
import clase15.Pages.SpotifySignupPage;
import clase16.Pages.HomePageNtflxNetflix;
import clase16.Pages.LoginPageNtflx;
import clase16.TestsBase.BaseTests;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NetflixTests extends BaseTests {

    private LoginPageNtflx login;

    @Test
    public void validarTituloTest(){
       // System.out.println(homePageNetflix.getPageTitle());
       Assert.assertEquals(homePageNetflix.getPageTitle(),"Netflix España - Ver series en línea, ver películas en línea");
    }

    @Test
    public void iniciarSesionPageTest(){
       login = homePageNetflix.iniciarSesion();
      //  System.out.println(login.getPageTitle());
        Assert.assertEquals(login.getPageTitle(),"Netflix");
      //  System.out.println(login.validateH1Texts());
        Assert.assertEquals(login.validateH1Texts(),"Iniciar sesión");
    }

    @Test
    public void  loginToNetflixErrorTest() {
        login = homePageNetflix.iniciarSesion();
        login.fillLoginFields();
        Assert.assertEquals(login.GetErrorElement(),"Escribe un correo válido.");
        login.marcarDesmarcarCheckboxRecuerdame();

    }

}
