package tests.day04_locators_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3- arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //4- Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoriElementleriList = driver.findElements(By.className("panel-list"));

        int expectedCategoriSayisi = 8 ;
        int actualCategorisayisi = categoriElementleriList.size();

        if (expectedCategoriSayisi == actualCategorisayisi){
            System.out.println("Category sayisi testi PASSED");
        }else System.out.println("Category sayisi testi FAILED");

        //5- Category isimlerini yazdirin

        System.out.println(categoriElementleriList);
        // category'ler webelement oldugu icin direkt yazdirilamaz

        // bir for-each loop ile herbir webelementi ele alip, ustundeki yaziyi yazdiralim
        // eger yazilari bir liste olarak istersek
        // her bir webelementi ele aldigimizda yazisini string list'e ekleriz

        for (WebElement eachElement :categoriElementleriList){

            System.out.println(eachElement.getText());
        }

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
