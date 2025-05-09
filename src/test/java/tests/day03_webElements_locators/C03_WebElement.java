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

        // WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        WebElement aramaKutusu = driver.findElement(By.name("search"));

        aramaKutusu.sendKeys("phone");
        Thread.sleep(3000);
        aramaKutusu.submit();

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        // arama sonucunu yazdirip gorelim
        System.out.println(aramaSonucElementi);
        // [[ChromeDriver: chrome on mac (fcefc04f7a99a4b8227fb0a7770fc3ed)] -> class name: product-count-text]
        // aramaSonucElementi'in data turu WebElement
        // WebElement non-primitive data turu oldugundan
        // yazdirdigimizda bize referansini yazdirir
        // eger webelement uzerindeki yaziyi istersek
        System.out.println(aramaSonucElementi.getText()); // 4 Products Found


        // bu yazidan urunun bulunabildigini test edelim
        // urun bulunamazsa yazi "0 Products Found" oluyor
        // eger bu yazi gorunuyorsa test failed olur
        // bu yazi gorunmuyorsa test passed olur

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucyazisi = aramaSonucElementi.getText();


        if (actualSonucyazisi.equals(unExpectedSonucYazisi)){
            System.out.println("Test FAILED");
        } else System.out.println("Test PASSED");

        // sayfayi kapatin
        Thread.sleep(5000);
        driver.quit();
    }



}
