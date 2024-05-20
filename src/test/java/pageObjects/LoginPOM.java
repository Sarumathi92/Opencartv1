package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPOM extends BasePage_Constructor
{

    //Constructor
   public LoginPOM(WebDriver driver)
    {
        super(driver);
    }

    //Locator
    @FindBy(xpath = "//input[@name='email']")
    WebElement txt_email;

   @FindBy(xpath = "//input[@name='password']")
    WebElement txt_Password;

   @FindBy(xpath = "//input[@type='submit']")
    WebElement but_login;

   @FindBy(xpath = "//h2[normalize-space()='My Account']")
   WebElement txt_Myaccountmessage;


    //@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
   // WebElement button_Logout;





   //Action Method
    public void enteremail(String email)
    {
        txt_email.sendKeys(email);
    }
    public void enterpassword(String pwd)
    {
        txt_Password.sendKeys(pwd);
    }
   public  void clicklogin()
    {
        but_login.click();
    }
    /*public void clicklogout()
    {
        button_Logout.click();
    }

     */
    public String confirmmessage()
    {
        try
        {
            return (txt_Myaccountmessage.getText());
        }
        catch(Exception e)
        {
            return(e.getMessage());
        }

    }






}
