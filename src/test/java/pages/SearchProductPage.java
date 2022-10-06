package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchProductPage {
    public SearchProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement prouducts;
    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProuductTitle;
    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searchBox;
    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchProductTitle;

    @FindBy(linkText = "View Product")
    public WebElement viewProduct;
    @FindBy (xpath = "//h2[text()='Blue Top']")
    public WebElement blueTop;

}