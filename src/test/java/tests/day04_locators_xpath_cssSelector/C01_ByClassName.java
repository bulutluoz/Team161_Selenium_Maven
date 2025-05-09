package tests.day04_locators_xpath_cssSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByClassName {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin


        // arama sonucunda urun bulunabildigini test edin

        // bulunan urunlerden ilkini tiklayin

        // acilan urun sayfasindaki urun isminde
        // case sensitive olmaksizin "phone" bulundugunu test edin

        // sayfayi kapatin
    }
}
