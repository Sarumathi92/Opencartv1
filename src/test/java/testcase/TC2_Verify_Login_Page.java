package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomepagePOM;
import pageObjects.LoginPOM;

public class TC2_Verify_Login_Page extends Baseclass
{

    //call method from loginpom
    //create object for loginPOM
    @Test(groups = "Sanity")
    public void verify_Login_Page()
    {
        //Homepage method also import
        HomepagePOM hp=new HomepagePOM(driver);
        logger.info("******Click my account");
        hp.clickmyaccount();
        hp.clicklogin();
        logger.info("***Click login link");
        logger.info("**** Login test started");


        //Loginpage
        LoginPOM lp=new LoginPOM(driver);
        lp.enteremail(p.getProperty("email"));
        logger.info(" ***** Enter email");
        lp.enterpassword(p.getProperty("pwd"));
        logger.info("***** Enter password");
        lp.clicklogin();
        logger.info("***** Click Login");

        //myaccountpage
        String myaccountconfmessage=lp.confirmmessage();
        Assert.assertEquals(myaccountconfmessage,"My Account");

        logger.info("****Sucessfull login");
    }
}
