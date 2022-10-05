package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Pozitif Test", "Geçerli kullanıcı adı ve password ile giriş yapıldı");
        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");
        //    -login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.brclogin.click();
        extentTest.info("Login butonuna basıldı");
        //    -test data user email: customer@bluerentalcars.com ,
        //    -test data password : 12345 dataları girip login e basın -login butonuna tiklayin
        brcPage.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanıcı email ve password girildi");
        extentTest.info("İkinci login butonuna basıldı");

        //**tekrar locate almamak icin actions yaptık yoksa password ve login tekrar locata yapmakmgerekir

        //    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     /*
     sayfaya girilebildiğini test edin dediği zaman ilk olarak  almayı düşüneceğimiz şey nedir
     URL , logo , title olabilir
     */
        String actualUserName = brcPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName, actualUserName);
        //   2.yol Assert.assertTrue(brcPage.basariliGiris.isDisplayed());
        extentTest.pass("Sayfaya başarılı bir şekilde girildi");

        //eğer hata raporu alırsak ve raporda resmi görüntülemek istersek rapor üzerine sağ click
//open, explorer secip resimli raporu görüntüleyebiliriz.
    }
}
