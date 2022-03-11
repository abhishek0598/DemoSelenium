package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.*;

public class AlertPopup {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("99.0.4844.51").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement alert = driver.findElement(By.linkText("JavaScript Alerts"));
        alert.click();

        WebElement JsAlert = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
        JsAlert.click();

        Alert alert1 = driver.switchTo().alert();
        String alert1Text = alert1.getText();
        System.out.println("Text inside alert1 is:"+alert1Text);
        alert1.accept();
        if(driver.getPageSource().contains("You successfully clicked an alert"))
            System.out.println("You successfully clicked an alert");
        System.out.println("=======================================");



        WebElement JSconfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        JSconfirm.click();

        Alert alert2 = driver.switchTo().alert();
        String alert2Text = alert2.getText();
        System.out.println("Text inside alert1 is:"+alert2Text);
        sleep(1000);
        alert2.dismiss();

        if(driver.getPageSource().contains("You clicked: Cancel"))
            System.out.println("You clicked: Cancel");
        System.out.println("=======================================");


        WebElement JSprompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        JSprompt.click();

        Alert alert3 = driver.switchTo().alert();
        String alert3Text = alert3.getText();
        System.out.println("Text inside alert1 is:"+alert3Text);
        Thread.sleep(1000);
        alert3.sendKeys("switching to alert and inputing in it");
        Thread.sleep(1000);
        alert3.accept();

        if(driver.getPageSource().contains("You entered: switching to alert and inputing in it"))
            System.out.println("You entered: switching to alert and inputing in it");

    }
}
