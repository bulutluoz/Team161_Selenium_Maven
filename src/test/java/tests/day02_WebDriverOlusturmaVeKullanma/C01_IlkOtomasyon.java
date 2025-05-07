package tests.day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) {

        /*
            Selenium ile test otomasyonu yapmak icin
            elimiz ve gozumuzle , klavye ve mouse kullanarak yapabilecegimiz
            COGU islemi bizim yerimize
            Selenium WebDriver objesi yapar

            Yaanniiii
            bir test otomasyonu yapmak istedigimizde
            ILK YAPMAMIZ GEREKEN sey
            bir Webdriver objesi EDINMEKTIR
         */

        // WebDriver driver = new WebDriver();
        // 'WebDriver' is abstract; cannot be instantiated
        // WebDriver bir interface'dir ve
        // interface'lerden direkt olarak obje olusturulamaz
        // obje olusturmak icin child class'larinin constructor'i kullanilabilir

        WebDriver driver = new ChromeDriver();

        // driver.get("URL") yazdigimiz url'e goturur
        // driver.get("https://www.testotomasyonu.com");


        /*
            Notlar :
            1- Consolda gorulen her kirmizi yazi Java'daki gibi hata anlamina gelmez
               consolda
               "Process finished with exit code 0" yazisi varsa
               kod sorunsuz olarak calisip bitti demektir

            2- WebDriver olustursak ama
               objeyi hic kullanmasak
               Selenium bos bir browser olusturur
               ve emirlerinizi bekler

            3- Selenium bilgisayarimizda var olan browser'i degil
               var olan browser'in selenium tarafindan olusturulan kopyasini kullanir
               driver objesinin actigi browser'in basinda
               "Chrome is being controlled by automated test software" yazar


         */

    }
}
