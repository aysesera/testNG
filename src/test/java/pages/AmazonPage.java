package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {//const oluturup pıblic yapmalıyız

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
//bu Depo lar sadece locate ler icin kullanılır
    @FindBy(id = "twotabseachtextbox")
    public WebElement aramaKutusu;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucuWE;

}
