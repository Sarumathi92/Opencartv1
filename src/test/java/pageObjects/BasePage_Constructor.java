package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage_Constructor
{
    WebDriver driver;//class veriable
    public BasePage_Constructor(WebDriver driver)//local variable
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
