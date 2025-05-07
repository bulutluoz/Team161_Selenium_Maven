package tests.day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTestOtomasyonu {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //2. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //4. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.

        String expectedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("url testi PASSED");
        } else System.out.println("url testi FAILED");

        /*
            Bir tester olarak bize dusen gorev
            testin PASSED olmasini saglamak degil
            Requirements'da belirlenmis sartlarin gerceklesip gerceklesmedigini test etmektir

            Eger requirements'a uygun sonuc cikmiyorsa
            Test FAILED olmali ve biz de bunu raporlamaliyiz
            Bug illa calismayi engelleyen bir hata olmak zorunda degildir
                requirements'a uymayan hersey Bug olarak rapor edilir

            Biz rapor ettikten sonra
            Requirement'i kim hazirladi ise
            o bu durumu duzeltecek karari vermelidir
            Ya requirements degistirilir,
            Ya da actual sonucun requirements'a uymasi saglanir
         */

        //6. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin

        String expectedHtmlIcerik = "otomasyon";
        String actualSayfaKaynagi = driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedHtmlIcerik)){
            System.out.println("Sayfa kaynak kodu testi PASSED");
        } else System.out.println("Sayfa kaynak kodu testi FAILED");

        //8. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.quit();
    }
}
