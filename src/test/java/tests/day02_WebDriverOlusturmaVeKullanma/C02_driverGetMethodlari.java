package tests.day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        System.out.println(driver.getWindowHandle());
        // 72B4B1422C9EAD12A694E914149B9C99

        System.out.println(driver.getWindowHandles());
        // [72B4B1422C9EAD12A694E914149B9C99]

        /*
            Selenium bilgisayarimizda var olan browser'lari degil
            kendi olusturdugu KOPYA BROWSER'lari kullanir

            Her olusturdugu kopya browser'a da
            Unique bir handle degeri atama yapar

            Eger test sirasinda sadece 1 window acildiysa
            ikisi de ayni degeri getirir, farklari b
            getWindowHandle() driver'in handle degerini direkt string olarak getirirken
            getWindowHandles() driver'in handle degerini bir Set olarak getirir

            Eger test sirasinda sadece 1'den fazla window acildiysa
            ikisi farkli degerler getirir,
            getWindowHandle() driver'in son actigi browser'in handle degerini getirirken
            getWindowHandles() driver'in actigi tum window'larin
            window handle degerlerini bir Set olarak getirir

            Window handle degeri
            test sirasinda birden fazla window acilirdiginda
            bu window'lar arasinda gecis icin kullanilir
         */



        System.out.println(driver.getPageSource());
        // HTML sayfanin tum kaynak kodlarini getirir
        // sayfa kaynaginda otomasyon kelimesi geciyor mu gibi bir test yapilacaksa kullanilabilir


        Thread.sleep(3000);
        driver.quit();
    }
}
