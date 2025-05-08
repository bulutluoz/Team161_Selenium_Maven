package tests.day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElement {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna "phone" yazip aratin

        // Bir webelementi kullanmak istedigimizde
        // 1- ilk yapmamiz gereken sey
        // o webelementin HTML kodlarini incelemek
        // ve unique olarak o webelement'i tarif edebilecegimiz bir ozelligini bulmak

        // arama kutusunun HTML kodunu inceledigimizde id = global-search oldugunu
        // ve id'si global-search olan unique element oldugunu gorduk

        // 2- unique adresini buldugumuz HTML elementi
        //    driver'a tarif edip,
        //    bunu kodlarimiz icinde kullanacagimiz bir obje olarak kaydetmek

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone");




        // arama sonucunda urun bulunabildigini test edin

        // sayfayi kapatin
        Thread.sleep(5000);
        driver.quit();
    }



}
