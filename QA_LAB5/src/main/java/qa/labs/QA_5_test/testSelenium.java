package qa.labs.QA_5_test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class testSelenium {
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eduar\\Desktop\\qa\\chromedriver.exe");
    }
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");
        driver.findElement(By.id("header-search-bar")).sendKeys("computer", Keys.RETURN);
        if( driver.findElement(By.className("_2vkeRJojnV7cb9pMlPHy7d")).isDisplayed()){
            System.out.println("Header is Visible");
        }
        else{
            System.out.println("Header is InVisible");
        }
        driver.quit();
    }
}
