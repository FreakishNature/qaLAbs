package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.lang.model.element.Element;

import static org.junit.Assert.*;

public class StepDefinitions {
    static {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eduar\\Desktop\\qa\\chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();

    private String lowerCaseFirstResult = null;
    private String upperCaseFirstResult = null;

    public void startSearch(){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.RETURN);
    }
    @Given("user opens Google")
    public void openGoogle(){
        driver.get("https://www.google.com/");
    }
    @When("user enters english text")
    public void enterEnglishText(){
        openGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("test");
        startSearch();
        lowerCaseFirstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).getText();
    }
    @When("user enters russian text")
    public void enterRussianText(){
        openGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("тест");
        startSearch();
    }
    @When("user enters upper case text")
    public void enterUpperCaseText() {
        openGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("TEST");
        startSearch();
        upperCaseFirstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).getText();
    }
    @When("user enters \"calculator\"")
    public void enterCalculator(){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("calculator");
        startSearch();
    }
    @When("user enters \"converter\"")
    public void enterConverter(){
        openGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("converter");
        startSearch();
    }
    @Then("check that converter is at the top")
    public void checkConverterAtTheTop(){
        if (!driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span")).isDisplayed())
            Assert.fail();

    }
    @Then("check that calculator is displayed")
    public void checkCalculatorIsDisplayed(){
        if (!driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div")).isDisplayed())
            Assert.fail();
    }
    @Then("check that user receives the same result as with lower case")
    public void checkTextCaseSearchResult(){
        if (!lowerCaseFirstResult.equals(upperCaseFirstResult))
            Assert.fail();
        driver.quit();
    }
    @Then("check that user receives a result independently of language used")
    public void checkLanguageResult(){
        if (!driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).isDisplayed())
            Assert.fail();
    }


}
