package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BrowserActions {

    public static void main(String args[]) throws InterruptedException, IOException {


        //handling browser driver with WebDriverManager(it stores binary of browsers)
        WebDriverManager.chromedriver().driverVersion("99.0.4844.51").setup();
        WebDriver driver = new ChromeDriver();

        /* handling browser driver by setting properties
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        */

        //Browser Actions


        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String OriginalWindows = driver.getWindowHandle();

        System.out.println("url of website is:"+driver.getCurrentUrl());
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.switchTo().window(OriginalWindows);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Title of Page is:"+driver.getTitle());


        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        String web = driver.getWindowHandle();

        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Alert")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        Dimension size = driver.manage().window().getSize();
        System.out.println("Size of window is:"+ size);

        int width = size.getWidth();
        int height = size.getHeight();

        System.out.println("width of current window is:"+ width);
        System.out.println("height of current window is:"+ height);

        driver.manage().window().setSize(new Dimension(1200,600));

        Dimension resized = driver.manage().window().getSize();
        System.out.println("dimension of window now is:"+ resized);

        Point position = driver.manage().window().getPosition();
        System.out.println("position of window is:"+ position);
        int x = position.getX();
        int y = position.getY();

        System.out.println("x position of window is:"+ x);
        System.out.println("y position of window is:"+ y);

        driver.manage().window().setPosition(new Point(50,50));

        Point reposition = driver.manage().window().getPosition();
        System.out.println("new position of window is:"+ reposition);

        driver.manage().window().minimize();
//        Thread.sleep(10000);

        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

//        Taking screenshot
        File Scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Scrfile,new File("./Screenshot/image.png"));

//        taking screenshot of an element
        driver.switchTo().window(web);
        driver.switchTo().frame("classFrame");
        WebElement element = driver.findElement(By.cssSelector("body > header > nav > div.fixedNav > div.topNav > ul > li:nth-child(2)"));

        File elementscr = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementscr, new File("./ElementScreenshot/element.png"));

        driver.switchTo().window(web);
            driver.switchTo().frame("packageListFrame");
        WebElement element1 = driver.findElement(By.linkText("org.openqa.selenium.docker"));
        File element1scr = element1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(element1scr, new File("./ElementScreenshot/element1.png"));


        //Implementation of Javascript executor
        driver.switchTo().window(OriginalWindows);

        JavascriptExecutor js= (JavascriptExecutor)driver;

        WebElement webElement= driver.findElement(By.linkText("Products"));
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();",webElement);
        Thread.sleep(1000);
        js.executeScript("console.log('helloworld')");




    }
}
