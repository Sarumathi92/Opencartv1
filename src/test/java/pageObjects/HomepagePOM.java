package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomepagePOM extends BasePage_Constructor
{
    //constructortZA
    public HomepagePOM(WebDriver driver)
    {
        super(driver);
    }

    //Locator
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement link_My_account;
    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement link_Register;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement link_Login;


    //Action Methods
    public void  clickmyaccount()
    {
        link_My_account.click();
    }
    public  void clickregister()
    {
        link_Register.click();
    }
    public void clicklogin()
    {
        link_Login.click();
    }

    }
