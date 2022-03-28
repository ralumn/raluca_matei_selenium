package clase16.Tests;

import clase16.Pages.LoginPageNtflx;
import clase16.TestsBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NetflixTests extends BaseTest {

    private LoginPageNtflx login;

    @Test
    public void validarTituloTest(){
       // System.out.println(homePageNetflix.getPageTitle());
       Assert.assertEquals(homePageNetflix.getPageTitle(),"Netflix España - Ver series en línea, ver películas en línea");
    }

    @Test
    public void iniciarSesionPageTest(){
       login = homePageNetflix.goToIniciarSesionPage();
      //  System.out.println(login.getPageTitle());
        Assert.assertEquals(login.getPageTitle(),"Netflix");

        String h1 = login.getAllH1();
        System.out.println(h1);
        Assert.assertEquals(h1,"Iniciar sesión");
    }

    @Test
    public void  loginToNetflixErrorTest() {
        login = homePageNetflix.goToIniciarSesionPage();
        login.fillLoginFields();
        Assert.assertEquals(login.getErrorElement(),"Escribe un correo válido.");
        Boolean isCheckboxSelected = login.marcarDesmarcarCajaRecuerdame();
        System.out.println(isCheckboxSelected);
        Assert.assertFalse(isCheckboxSelected,"El checkbox no debería estar marcado");

    }

}
