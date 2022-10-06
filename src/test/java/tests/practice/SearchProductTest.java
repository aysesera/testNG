package tests.practice;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;

public class SearchProductTest {
    // 1. Tarayıcıyı başlat
// 2. 'http://automationexercise.com' url'sine gidin
// 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
// 4. 'Ürünler' butonuna tıklayın
// 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
// 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
// 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
// 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
    SearchProductPage searchProductPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void searchProductPage() {

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get("http://automationexercise.com");

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String homeUrl = "https://automationexercise.com/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), homeUrl);

        searchProductPage = new SearchProductPage();

        // 4. 'Ürünler' butonuna tıklayın
        searchProductPage.prouducts.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        //1. yol
        Assert.assertTrue(searchProductPage.allProuductTitle.isDisplayed());

        //2.yol
        //String productPageUrl = "https://automationexercise.com/products";
        //Assert.assertEquals(Driver.getDriver().getCurrentUrl(),productPageUrl);

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        searchProductPage.searchBox.sendKeys("blue top");
        searchProductPage.searchButton.click();

// 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(searchProductPage.searchProductTitle.isDisplayed());
// 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
        actions.click(searchProductPage.viewProduct).perform();
        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());

    }
}