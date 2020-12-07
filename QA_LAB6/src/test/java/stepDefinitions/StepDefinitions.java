package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eduar\\Desktop\\qa\\chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();
    String path = "https://adoring-pasteur-3ae17d.netlify.app/mens.html\n";
    @Given("user fills in search bar with dummy data and presses search")
    public void fillSearch(){
        driver.findElement(By.name("search")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class=\"header-bot\"]//input[@type=\"submit\"]")).click();
    }
    @Given("user accesses the shop")
    public void enterTheShop(){
        driver.get(path);
        driver.manage().window().maximize();
    }
    @Given("chooses a product")
    public void chooseAProduct(){
        int productIndex = 1;
        driver.findElement(By.xpath("(//div//h4/a)[" + productIndex + "]")).click();
    }
    @Given("and clicks review")
    public void clickReview() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/ul/li[2]")).click();
    }
    @When("user clicks signup")
    public void clickSignUpOnly() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[2]/a")).click();
        Thread.sleep(500);
    }
    @When("user clicks sign up")
    public void clickSignUp() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[2]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/div[1]/input")).sendKeys("testName");
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/div[2]/input")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/div[3]/input")).sendKeys("testPassword");
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/div[4]/input")).sendKeys("testPassword");
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/input")).click();

    }
    @When("user adds product to cart")
    public void addProdToCart(){
        driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div[1]/div/div[2]/div[2]/form/fieldset/input[10]")).click();
    }
    @When("user tries leave a review")
    public void leaveAReview() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div/div[2]/div/div/div[2]/form/input[1]")).sendKeys("testName");
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div/div[2]/div/div/div[2]/form/input[2]")).sendKeys("test@test.ru");
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div/div[2]/div/div/div[2]/form/textarea")).sendKeys("sample review");
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div/div[2]/div/div/div[2]/form/input[3]")).click();
    }
    @When("user clicks on I agree etc.")
    public void termsAgreements() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/p/a")).click();
    }
    @When("adds to cart")
    public void addFromQView() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[5]/div/form/fieldset/input[10]")).click();
    }
    @Then("Sign in or Sign up successfull")
    public void checkSignIn()throws InterruptedException{
        try{
            if (driver.findElement(By.xpath("/html/body/div/div/div[1]/h1")).isDisplayed())
                Assert.fail();
            else System.out.println("Passed");
        }
        finally {
            Thread.sleep(500);
            driver.quit();
        }
    }

    @Then("product is in cart")
    public void prodInCart() throws InterruptedException{
        try{////*[@id="PPMiniCart"]/form/ul/li/div[1]
            if (driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li[1]")) == null)
                Assert.fail();
            else System.out.println("Passed");
        }
        finally {
            Thread.sleep(500);
            driver.quit();
        }
    }
    @Then("product is in the cart")
    public void prodInTheCart() throws InterruptedException{
        try{
            if (driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[1]")) == null)
                Assert.fail();
            else System.out.println("Passed");
        }
        finally {
            Thread.sleep(500);
            driver.quit();
        }
    }
    @Then("is directed to items")
    public void directedToItems() throws InterruptedException{
        try {
            if (driver.findElement(By.xpath("/html/body/div/div/div[1]/h1")).isDisplayed())
                Assert.fail();
            else System.out.println("Passed");
        }
        finally {
            Thread.sleep(500);
            driver.quit();
        }
    }
    @Then("a review is left")
    public void reviewLeft() throws InterruptedException{
        try {
            if (driver.findElement(By.xpath("/html/body/div/div/div[1]/h1")).isDisplayed())
                Assert.fail();
            else System.out.println("A review was left");
            Thread.sleep(500);
        }
        finally {
            driver.quit();
        }

    }
    @Then("terms and agreements displayed")
    public void checkTerms() throws InterruptedException{
        try {
            driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/input")).click();
            Assert.fail();
        }
        catch (ElementNotInteractableException e){
            System.out.println("Passed");
        }
        finally {
            driver.quit();
        }
    }


}
