package tests.day04_locators_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_XPath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@id='sub-btn']"))
                .click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu = driver.findElement(By.xpath("//button[@class='remove-btn']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove button testi PASSED");
        }else System.out.println("Remove button testi FAILED");

        //4- Remove tusuna basin
        removeButonu.click();


        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("add remove yazi testi PASSED");
        }else System.out.println("add remove yazi testi FAILED");

        driver.quit();
    }
}
