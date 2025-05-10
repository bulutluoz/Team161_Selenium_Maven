package tests.day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {
        /*
            Relative locator kullanmak zorunda oldugumuz birsey degildir

            EGER bir webelement'i locate ettigimiz halde KULLANAMIYORSAK
            ALTERNATIF bir yontem olarak Relative Locator denenebilir
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        // once kendini locate edip tiklamaya calisalim
        driver.findElement(By.id("pic7_thumb")).click();
        // kendisini kullanabildigimiz icin relative locator kullanmaya gerek yok

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement acilanSayfadakiUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunAdi = "DSLR Camera";
        String actualUrunAdi = acilanSayfadakiUrunIsimElementi.getText();

        if (expectedUrunAdi.equals(actualUrunAdi)){
            System.out.println("Kendini click yapma testi PASSED");
        } else System.out.println("Kendini click yapma testi FAILED");

        Thread.sleep(2000);

        // Mecbur olmasak da Relative locator'i gormek icin deneyelim
        driver.get("https://testotomasyonu.com/relativeLocators");

        // Relative locator icin 2 seye ihtyacimiz var

        // 1.ihtiyac:  hedef elementi tarif edebilecek bir locator
        //    By.id("pic7_thumb")

        // 2.ihtiyac: hedef element etrafinda tarif icin kullanabilecegimiz bir webelement
        //    biz "Apple headphone'un sagindaki" diyelim
        WebElement appleHeadphone = driver.findElement(By.id("pic6_thumb"));


        //2.Locate   DSLR Camera’yi  etrafindaki elementleri kullanarak
        //           3 farkli relative locator ile locate edip tiklayin
        WebElement dslrCameraAppleinSagi =
                driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleHeadphone));

        dslrCameraAppleinSagi.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        // actualUrunAdi = acilanSayfadakiUrunIsimElementi.getText();
        // StaleElementReferenceException
        // element stale (bayatlamis)
        // Eger bir sayfa acildiktan sonra, baska sayfalara gidip
        // yeniden ilk sayfaya dondugunuzde
        // webelementler ayni olsa bile daha once yapilan locate KULLANILMAZ


        acilanSayfadakiUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));


        actualUrunAdi = acilanSayfadakiUrunIsimElementi.getText();
        expectedUrunAdi = "DSLR Camera";

        if (expectedUrunAdi.equals(actualUrunAdi)){
            System.out.println("Apple kulakligin sagi testi PASSED");
        } else System.out.println("Apple kulakligin sagi testi FAILED");


        // 3.defa bAt Rockerz kulakligin altinda diyerek locate edelim
        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement rockertzKulaklik = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCameraRockertzAltinda=
                driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).below(rockertzKulaklik));

        dslrCameraRockertzAltinda.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        acilanSayfadakiUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));


        actualUrunAdi = acilanSayfadakiUrunIsimElementi.getText();
        expectedUrunAdi = "DSLR Camera";

        if (expectedUrunAdi.equals(actualUrunAdi)){
            System.out.println("Rockertz kulaklik alti testi PASSED");
        } else System.out.println("Rockertz kulaklik alti testi FAILED");


        Thread.sleep(3000);
        driver.quit();


    }
}
