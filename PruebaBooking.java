package SimulacroExamen.Tests;

import SimulacroExamen.DataProviderGenerator;
import SimulacroExamen.Pages.HomePageBooking;
import SimulacroExamen.Pages.RegisterPasswordPage;
import SimulacroExamen.Pages.SignUpPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PruebaBooking extends TestBase{

    private SignUpPage signUpPage;
    private RegisterPasswordPage registerPasswordPage;

    @Test
    public void validarTituloTest(){
        Assert.assertEquals(homePageBooking.getPageTitle(),"Booking.com | Sitio oficial | Los mejores hoteles, vuelos, coches de alquiler y alojamientos");
    }

    @Test
    public void mostarLinksTest(){
       homePageBooking.getAllLinks();
    }

    @Test
    public void mostarH1sTest(){
        homePageBooking.getAllH1();
    }

    @Test
    public void buscarGenteViajeraTest(){
        String h2Encontrado= homePageBooking.getAllH2();
        Assert.assertEquals(h2Encontrado,"Conecta con gente viajera");
    }
    @Test(dataProvider = "passwords", dataProviderClass = DataProviderGenerator.class)
    public void validErrorMessagesPasswordTests(String password, String confirmedPassword, String scenario){
        signUpPage= homePageBooking.goToLogin();
        Assert.assertEquals(homePageBooking.getPageTitle(),"Booking.com");
        signUpPage.mail();
        registerPasswordPage= signUpPage.submitButton();
        registerPasswordPage.setPassword(password);
        registerPasswordPage.setConfirmPassword(confirmedPassword);
        registerPasswordPage.createAccountButton();

        List<WebElement> errors = registerPasswordPage.errorsPassword();
        for(WebElement elemento : errors){
            String texto= elemento.getText();
            if(texto.contains("coinciden") && scenario.equals("NO_COINCIDEN")){
                Assert.assertEquals(texto,"Las contraseñas no coinciden. Inténtalo de nuevo.");
                System.out.println(texto);
            }else if (texto.contains("10 caracteres") && scenario.equals("LONGITUD_INCORRECTA")){
                Assert.assertEquals(texto,"La contraseña debe tener al menos 10 caracteres");
                System.out.println(texto);
            }else if (texto.contains("numero") && scenario.equals("FALTA_NUMERO")){
                Assert.assertEquals(texto,"La contraseña debe incluir al menos un número");
                System.out.println(texto);
            }else if (texto.contains("mayúscula") && scenario.equals("FALTA_MAYUSCULA")){
                Assert.assertEquals(texto,"La contraseña debe incluir al menos una letra en mayúscula");
                System.out.println(texto);
            }else if(scenario.equals("CORRECTO")){
                System.out.println("Contraseña correcta");
            }
        }
    }


}
