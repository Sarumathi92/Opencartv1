package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page_POM extends BasePage_Constructor
{
    public WebDriver driver;

    //consturtorr
    public MyAccount_Page_POM(WebDriver driver)
    {
        super(driver);

    }


    //Locator
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txt_Myaccountmessage;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement button_Logout;


    //Action method
    public boolean myaccountmessageexist() {
        try {
            return (txt_Myaccountmessage.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }
    public void clicklogout()
    {
        button_Logout.click();
    }


}