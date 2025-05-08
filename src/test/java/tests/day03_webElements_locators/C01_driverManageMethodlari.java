package tests.day03_webElements_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testotomasyonu.com");

        // driver.manage() method'lari sayesinde
        // driver'in actigi browser'in boyutlarini kontrol edebiliriz

        System.out.println("baslangictaki konum : " + driver.manage().window().getPosition());
        // baslangictaki konum : (22, 60)
        System.out.println("baslangictaki boyut : " +driver.manage().window().getSize());
        // baslangictaki boyut : (1200, 1035)
        Thread.sleep(3000);

        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(100,100));

        System.out.println("duzenledikten sonra konum : " + driver.manage().window().getPosition());
        // duzenledikten sonra konum : (100, 100)
        System.out.println("duzenledikten sonra boyut : " +driver.manage().window().getSize());
        // duzenledikten sonra boyut : (500, 500)

        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println("maximize konum : " + driver.manage().window().getPosition());
        // maximize konum : (0, 38)
        System.out.println("maximize boyut : " +driver.manage().window().getSize());
        // maximize boyut : (1728, 1079)

        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("full screen konum : " + driver.manage().window().getPosition());
        // full screen konum : (0, 37)
        System.out.println("full screen  boyut : " +driver.manage().window().getSize());
        // full screen  boyut : (1728, 1080)




        Thread.sleep(3000);
        driver.quit();
    }
}
