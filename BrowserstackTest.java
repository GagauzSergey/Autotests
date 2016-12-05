package asiaTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

public class BrowserstackTest  {
	//Enter Browserstack account info 
    public static final String USERNAME = "gagauzsergey1";
    public static final String AUTOMATE_KEY = "GcT18xQmJwAxwKvkMaiE";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static WebDriver driver =null;

    @Test  //Test Run
    public void tripAsiaTest () throws  Exception  {
    	
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");      // enter Browser type
        caps.setCapability("browser_version", "47.0"); // enter Browser version
        caps.setCapability("os", "Windows");           // enter System type  
        caps.setCapability("os_version", "7");         // enter System version
        caps.setCapability("browserstack.debug", "true");
        
        driver = new RemoteWebDriver(new URL(URL), caps); 
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
    	driver.get("https://one2go.asia/en");
        driver.findElement(By.xpath(".//form[@id='search-form']/div[6]/button")).click();
        
        new WebDriverWait(driver, 30)
        		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.buy-button-text")));      

        driver.findElement(By.cssSelector("span.buy-button-text")).click();
        
        new WebDriverWait(driver, 30)
        		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Checkout!")));     

        driver.findElement(By.linkText("Checkout!")).click();        
        Thread.sleep(3000);
         
        new Select(driver.findElement(By.id("seats"))).selectByVisibleText("1 Person: THB 861");      
        Thread.sleep(3000);        
                         
                         driver.findElement(By.id("contact[mobile]")).sendKeys("+380502555555");
                         driver.findElement(By.id("contact[email]")).sendKeys("tt085901@gmail.com");
                         driver.findElement(By.id("passenger[0][full_name]")).sendKeys("Test Bot");
                         driver.findElement(By.id("passenger[0][id_no]")).sendKeys("123456");
                         driver.findElement(By.name("number")).sendKeys("4242");
                         driver.findElement(By.name("number")).sendKeys("4242");
                         driver.findElement(By.name("number")).sendKeys("4242");
                         driver.findElement(By.name("number")).sendKeys("4242");
                         driver.findElement(By.name("name")).sendKeys("TestBot");
                         driver.findElement(By.name("expiry")).sendKeys("02");
                         driver.findElement(By.name("expiry")).sendKeys("22");
                         driver.findElement(By.name("cvc")).sendKeys("222");
                         driver.findElement(By.xpath(".//div[@id='omise']/center/div/div[2]/div[3]/button")).click();                         
                         driver.close();                   
        }
    }


