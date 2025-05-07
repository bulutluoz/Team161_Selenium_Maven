package tests.day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

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
        driver.get("https://www.testotomasyonu.com");


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
            4- url adresi yazarken www kullanmazsak da driver istenen url'e gider
               AMMMMMAAAA https yazilmazsa kod calismaz

            5- olusturulan driver objesi gorevi bitirdiginde, kapatilmalidir
               kapatma icin driver.close() veya driver.quit() kullanilabilir

               ikisi arasindaki fark
               driver.close() : test sirasinda birden fazla window acilirsa,
                                sadece son kullandigini kapatir, oncekiler acik kalir
                                (sadece 1 window aciliyorsa sorun yok)
               driver.quit()  : test sirasinda birden fazla window acilirsa,
                                kendi actigi tum window'lari kapatir

             6- Otomasyonla calistirilan testlerin
                mumkun oldugunca kisa surede bitmesi tercih edilir
                ANCAKKK test adimlarinizi gormek veya
                bir sunum sirasinda test adimlarinizi gostermek isterseniz
                kodlari Thread.sleep() ile belirli bir sure bekletebilirsiniz

                Thread.sleep() compile time exception uyarisi verir
                ya throws kullanmalisiniz veya try-catch ile exception'i handle etmelisiniz

            7- test uzerinde ilk calisirken veya
               sunum yaparken koyacagimiz Thread.sleep()'leri
               calismamiz bittiginde silmemizde fayda var
               Silmezsek toplu calistirmalarda
               gereksiz yere ciddi zaman kaybi olacaktir


         */

        Thread.sleep(3000); // 3000 milisaniye = 3 saniye

        // driver.close();
        driver.quit();

    }
}
