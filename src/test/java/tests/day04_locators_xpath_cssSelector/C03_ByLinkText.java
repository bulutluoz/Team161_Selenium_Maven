package tests.day04_locators_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(3000);
        // sayfada cookie cikarsa elle mudahale edip kabul edecegiz


        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        if (expectedLinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        } else {
            System.out.println("Link sayisi testi FAILED");
        }

        //4- Products linkine tiklayin
        // WebElement productsLinkElementi = driver.findElement(By.linkText(" Products"));

        // eger tum yaziyi yazmak istemezsek
        // WebElement productsLinkElementi = driver.findElement(By.partialLinkText("Product"));
        // WebElement productsLinkElementi = driver.findElement(By.partialLinkText("oduct"));
        WebElement productsLinkElementi = driver.findElement(By.partialLinkText("duc"));



        productsLinkElementi.click();



        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYazielementi = driver.findElement(By.id("sale_image"));

        if (specialOfferYazielementi.isDisplayed()){
            System.out.println("Special offer yazi testi PASSED");
        } else System.out.println("Special offer yazi testi FAILED");

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
