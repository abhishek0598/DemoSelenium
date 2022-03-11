package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().driverVersion("99.0.4844.51").setup();

    }
}
