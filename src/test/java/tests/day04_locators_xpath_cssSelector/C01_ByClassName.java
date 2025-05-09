package tests.day04_locators_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.className("search-input"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // aramaKutusu.submit();

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        if (actualSonucYazisi.equals(unExpectedSonucYazisi)){
            System.out.println("Urun bulma testi FAILED");
        } else  System.out.println("Urun bulma testi PASSED");


        // bulunan urunlerden ilkini tiklayin

        // class attribute'u GENEL OLARAK ayni gorunume sahip
        // Webelementleri gruplandirmak icin kullanilir
        // bu durumda locate unique olmaz, o gorunume sahip kac eleman varsa hepsini isaret eder
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        bulunanUrunElementleriList.get(0).click();

        // By.className locator'i kullanirken
        // yazdigimiz locate'de space olmamasina dikkat etmemiz gerekir
        // eger locate'de bosluk(space) varsa By.className saglikli calismaz


        // acilan urun sayfasindaki urun aciklamasinda
        // case sensitive olmaksizin "phone" bulundugunu test edin

        // WebElement urunSayfasindaAciklamaElementi = driver.findElement(By.className("prod-detail"));

        WebElement urunSayfasindaAciklamaElementi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));


        String expectedUrunIcerik = "phone";
        String actualUrunAciklamasi = urunSayfasindaAciklamaElementi.getText().toLowerCase();
        // case sensitive olmamasi icin kucuk harfe cevirdik

        if (actualUrunAciklamasi.contains(expectedUrunIcerik)){
            System.out.println("Urun isim icerigi testi PASSED");
        } else  System.out.println("Urun isim icerigi testi FAILED");

        // sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}
