package tests.day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_driverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);

        // wisequarter anasayfaya gidin
        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(1000);

        // testotomasyonu anasayfaya geri donun
        driver.navigate().back();
        Thread.sleep(1000);

        // yeniden wisequarter anasayfaya gidin
        driver.navigate().forward();
        Thread.sleep(1000);

        driver.quit();
    }
}
