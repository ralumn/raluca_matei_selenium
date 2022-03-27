package clase16.Pages;

import org.openqa.selenium.WebDriver;

public class BasePageNtflx {

        protected WebDriver driver;


        public String getPageTitle(){
            return driver.getTitle();
        }
        public String getPageURL(){
            return driver.getCurrentUrl();
        }
}
