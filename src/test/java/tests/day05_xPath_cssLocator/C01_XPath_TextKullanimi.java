package tests.day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath_TextKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        //   Klasik olarak text ile locate ederken
        // driver.findElement(By.xpath("//button[text()='Add']")).click();

        // eger tag onemli degil yeterki yazisi 'Add' olsun demek istersek
        // driver.findElement(By.xpath("//*[text()='Add']")).click();

        // hatta text() yerine sadece . yazabiliriz
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu = driver.findElement(By.xpath("//button[.='Remove']"));
        if (removeButonu.isDisplayed()){
            System.out.println("Remove button testi PASSED");
        }else System.out.println("Remove button testi FAILED");
        Thread.sleep(1000);
        //4- Remove tusuna basin
        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazi testi PASSED");
        }else System.out.println("Add remove yazi testi FAILED");


        Thread.sleep(1000);
        driver.quit();


    }
}
