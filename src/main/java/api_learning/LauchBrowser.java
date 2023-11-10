package api_learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchBrowser {
    public static void main(String[] args) {

        /*
        * 1. Check current browser version
        * 2. Find the compatible browser driver from central and then download
        * 3. Use it as browser driver
         */
        WebDriver driver = new ChromeDriver();

        // Open web page
        driver.get("https://sdetpro.com");
        driver.quit();
    }
}
