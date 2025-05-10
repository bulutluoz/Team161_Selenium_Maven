package tests.day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath {
    public static void main(String[] args) throws InterruptedException {

        //1-  bir class olusturun
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/ ");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");


        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]"))
                .click();


        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minPriceKutusu = driver.findElement(By.xpath("//*[@*='form-control minPrice']"));
        WebElement maxPriceKutusu = driver.findElement(By.xpath("//*[@*='form-control maxPrice']"));

        // min ve max kutularina sayi gonderdigimizde
        // kutuda var olan 0'in gonderdigimiz sayinin sonuna eklendigini gorduk
        // once o 0'i silelim
        minPriceKutusu.clear();
        maxPriceKutusu.clear();
        Thread.sleep(5000);
        minPriceKutusu.sendKeys("40");
        maxPriceKutusu.sendKeys("200");

        // filtreleyin
        driver.findElement(By.xpath("//*[@*='price-range-button']")).click();

        //8-  filtreleme sonucunda urun bulunabildigini test edin


        //9-Ilk urunu tiklayin


        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin



        //11-Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
