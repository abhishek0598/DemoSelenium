package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElements {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().driverVersion("99.0.4844.51").setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

//Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(title));

//Fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);


        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();



        WebElement FirstName = driver.findElement(By.id("customer.firstName"));
        WebElement LastName = driver.findElement(By.id("customer.lastName"));
        WebElement Address = driver.findElement(By.id("customer.address.street"));
        WebElement City = driver.findElement(By.id("customer.address.city"));
        WebElement State = driver.findElement(By.id("customer.address.state"));
        WebElement ZipCode = driver.findElement(By.id("customer.address.zipCode"));
        WebElement Phone = driver.findElement(By.name("customer.phoneNumber"));
        WebElement SSN = driver.findElement(By.name("customer.ssn"));
        WebElement Username = driver.findElement(By.id("customer.username"));
        WebElement Password = driver.findElement(By.id("customer.password"));


//        Relative Locators
        WebElement RegButton = driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Register\"]"));
        WebElement ConfirmPassword =driver.findElement(RelativeLocator.with(By.tagName("input")).above(RegButton));


        FirstName.sendKeys("Abhishek");
        LastName.sendKeys("Rawat");
        Address.sendKeys("Sector-55");
        City.sendKeys("Chandigarh");
        State.sendKeys("Punjab");
        ZipCode.sendKeys("16008");
        Phone.sendKeys("987456213");
        SSN.sendKeys("45645645464654");
        Username.sendKeys("abhishek123@");
        Password.sendKeys("Rawat159@");
        ConfirmPassword.sendKeys("Rawat159@");

        RegButton.click();

        driver.close();
        driver.quit();
    }
}
