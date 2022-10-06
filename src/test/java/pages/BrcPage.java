package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
//1 constr olusturmak
//2-PageFactory den initElements(Driver.getDriver(), this); this ile cagırmak
//3- @FindBy notasyonu kullanmak
//
public class BrcPage {
    public BrcPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm']")
    public WebElement brclogin;
    @FindBy(xpath = "//*[@id='formBasicEmail']")
    public WebElement userEmail;
    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement basariliGiris;

    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement ikinciLogin;


}
