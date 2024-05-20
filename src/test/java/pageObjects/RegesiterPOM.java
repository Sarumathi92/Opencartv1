package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegesiterPOM extends BasePage_Constructor
{
    WebDriver driver;
    //constructor
    public RegesiterPOM(WebDriver driver)
    {
        super(driver);
    }

    //locator
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement txt_First_Name;
    @FindBy(xpath ="//input[@name='lastname']")
    WebElement txt_Last_Name;
    @FindBy(xpath = "//input[@name='email']")
    WebElement txt_Email;
    @FindBy(xpath ="//input[@name='telephone']")
    WebElement txt_Telephone;
    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_Password;
    @FindBy(xpath = "//input[@name='confirm']")
    WebElement txt_ConfirmPassword;
    @FindBy(xpath ="//input[@name='agree']")
    WebElement chxbox_agreepolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement button_continue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement Confirm_message;



    //Action method
    public  void firstname(String fname)
    {
        txt_First_Name.sendKeys(fname);
    }
    public void lastname(String lname)
    {
        txt_Last_Name.sendKeys(lname);
    }
    public  void email(String email)
    {
        txt_Email.sendKeys(email);
    }
    public void telephone(String tel)
    {
        txt_Telephone.sendKeys(tel);
    }
    public void password(String pwd)
    {
        txt_Password.sendKeys(pwd);
    }
    public void confirmpwd(String pwd)
    {
        txt_ConfirmPassword.sendKeys(pwd);
    }
    public void agreepolicy()
    {
        chxbox_agreepolicy.click();
    }
    public void butcontinue()
    {
        button_continue.click();
    }
public String confrimmessage()
{
    try
    {
        return(Confirm_message.getText());
    }
    catch (Exception e)
    {
        return (e.getMessage());
    }
}
}
