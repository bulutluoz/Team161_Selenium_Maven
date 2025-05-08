package tests.day03_webElements_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MahserinUcAtlisi {

    public static void main(String[] args) {

        // Otomasyon icin bir class olusturdugumuzda
        // ilk yapmamiz gereken sey bir webdriwer objesi olusturmak
        // ve gerekli ayarlari yapmaktir
        // Biz bu islem icin 3 satir kod yazacagiz
        // bunu Mahserin 3 atlisi olarak adlandiriyorum

        // WebDriverManager.chromedriver().setup();
        // sirket ozel bir WebDriver verirse bu mahserin 4.atlisi olur

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // implicitlyWait bilgisayarimiz, internetimiz veya
        // baglandigimiz websayfasinin server'indaki yavasliklari tolere eder
        // yazdigimiz 10 saniye, tolere edecegi maximum suredir
        // asil odak noktasi bekleme degil, islemin yapilmasidir
        // islem verilen zaman araligi icinde ne zaman biterse
        // daha fazla beklemeden yoluna devam eder
        // Eger verilen sure icerisinde islem tamamlanmazsa
        // exception firlatir ve calismayi durdurur

        // Thread.sleep() de bekleme yapar ama kullanisli degildir
        // kendisine verilen sure kadar kodlari bekletir
        // islem yapilmis olsa bile kodlari bekletmeye devam eder
        // bunun icin toplu calistirmalarda kullanissizdir

        //




    }
}
