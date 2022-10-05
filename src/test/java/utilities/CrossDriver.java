package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver() {//singeltonPattern icin CrossDriver() yaptık
    }

    static WebDriver driver;

        /* Testlerimizi xml file'dan farkli browserlar ile
            calistirabilmek icin getDriver() methoduna parametre atamamiz gerekir
            --getDriver(String browser)--
             */
    public static WebDriver getDriver(String browser) {
        //eger browser a bir deger atanmamıssa Properties'deki browser dosyasında tanımlı browser calissin
        browser=browser==null ? ConfigReader.getProperty("browser"):browser;


        if (driver == null) {
            switch (browser) {
                /*CrossBrowser için bizim gonderdigimiz browser uzerinden calısması icin
                buraya parametre olarak girdgimiz degeri yazdık */
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a değer atanmışsa kapat
            driver.close();
            driver = null; // Kapandıktan sonra sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }
    }

    public static void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }
}
