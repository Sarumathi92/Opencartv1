package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_InputBoxPOM extends BasePage_Constructor
{
    //constructor
    public Search_InputBoxPOM(WebDriver driver)
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



    //Action method
  public  void searchbox(String searchboxinput)
    {

        txt_searchbox.sendKeys(searchboxinput);
    }
  public  void clicksearchicon()
    {
        click_searchicon.click();
    }

   //validation
    public String Searchconfrimmeassage()
    {
       try
       {
           return (txt_confrimessage.getText());
       }
       catch(Exception e)
       {
           return (e.getMessage());
       }
    }



}
