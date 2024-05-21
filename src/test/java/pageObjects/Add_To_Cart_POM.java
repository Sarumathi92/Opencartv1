package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_To_Cart_POM extends BasePage_Constructor
{
    //constructor

    public Add_To_Cart_POM(WebDriver driver)
    {
        super(driver);
    }


    //Locator
    @FindBy(xpath = "//input[@type='text']")
    WebElement txt_searchbox;

    @FindBy(xpath = "//span[@class='input-group-btn']")
    WebElement click_searchicon;

    @FindBy(xpath="//h1[normalize-space()='Search - mac']")
    WebElement txt_confrimessage;

    @FindBy(xpath = "//a[normalize-space()='MacBook Pro']")
    WebElement click_Macbookpro;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successmesgaddtocart;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement click_Add_to_Cart;




    //Action method
    public  void searchbox(String searchboxinput)
    {

        txt_searchbox.sendKeys(searchboxinput);
    }
    public  void clicksearchicon()
    {
        click_searchicon.click();
    }
    public void clickmacpro()
    {
        click_Macbookpro.click();
    }
    public void click_add_to_Cart()
    {
        click_Add_to_Cart.click();
    }

    //validation
    public String addtocartconfrimmessage()
    {
        try
        {
            return(successmesgaddtocart.getText());
        }
        catch (Exception e)
        {
            return(e.getMessage());
        }
    }
    public String Searchconfrimmeassage() {
        try {
            return (txt_confrimessage.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }


    }

}
