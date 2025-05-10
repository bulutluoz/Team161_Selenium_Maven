package tests.day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

        // driver objesi ekranda gorunmeyen bir HTML webelement'i kullanabilir mi ?
        // bunun kesin bir cevabi yok
        // bazi web sayfalarinda kullanabilirken, bazilarinda kullanamayabilir
        // bunun icin once kullanacakmis gibi dusunup kodu yazmali ve calistirmaliyiz
        // eger herseyi dogru yaptigimiz halde
        // kod calismiyorsa, driver'in gorunmeyen elemani kullanamadigini anlariz
        // ve asagidaki kodu yazarak, once sayfanin asagi inmesini saglariz

        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // ilerde ayri bir konu olarak anlatilacak
        // sayfanin 1 kere PAGE_DOWN yapmasini saglar


        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minPriceKutusu = driver.findElement(By.xpath("//*[@*='form-control minPrice']"));
        WebElement maxPriceKutusu = driver.findElement(By.xpath("//*[@*='form-control maxPrice']"));

        // min ve max kutularina sayi gonderdigimizde
        // kutuda var olan 0'in gonderdigimiz sayinin sonuna eklendigini gorduk
        // once o 0'i silelim
        minPriceKutusu.clear();
        maxPriceKutusu.clear();
        Thread.sleep(1000);
        minPriceKutusu.sendKeys("40");
        maxPriceKutusu.sendKeys("200");

        // filtreleyin
        driver.findElement(By.xpath("//*[@*='price-range-button']")).click();

        //8-  filtreleme sonucunda urun bulunabildigini test edin
        //    sonuc yazisinin "0 Products Found" olmadigini test edelim
        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucYaziElementi.getText();

        if (unExpectedSonuc.equals(actualSonuc)){
            System.out.println("Filtreleme testi FAILED");
        } else System.out.println("Filtreleme testi PASSED");

        //9-Ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@class='lazy'])[1]"))
                .click();


        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        // System.out.println(urunFiyatElementi.getText()); // $50.00
        // fiyatin hangi formatta geldigini gormek icin yazdirdik
        // ve String olarak basinda $ arasinda . ile geldigini gorduk
        // once bunu matematiksel olarak karsilastirilabilir hale getirmeliyiz

        // once $'i yok edelim
        String urunFiyatiStr = urunFiyatElementi.getText();  // $50.00
        urunFiyatiStr = urunFiyatiStr.replace("$","");  // "50.00"

        double urunFiyati = Double.parseDouble(urunFiyatiStr);  // 50.00  sayi olarak

        if (urunFiyati>= 40 && urunFiyati<=200){
            System.out.println("Urun fiyat testi PASSED");
        } else System.out.println("Urun fiyat testi FAILED");


        //11-Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
