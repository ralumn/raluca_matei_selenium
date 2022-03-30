package SimulacroExamen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    protected WebDriver driver;


    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public void getAllLinks(){
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for (WebElement links : listaLinks) {
            System.out.println(links.getText());
        }
    }

    public void getAllH1() {
        //OBTENER ELEMENTOS h1
        String elemento ;
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));

        for (WebElement h1 : listaH1s) {
            elemento =h1.getText();
            System.out.println(elemento);
        }
    }
}
