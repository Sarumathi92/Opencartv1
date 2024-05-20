package testcase;

import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomepagePOM;
import pageObjects.LoginPOM;
import pageObjects.MyAccount_Page_POM;

import java.util.Iterator;

public class TC3_LoginDataDriven_Test extends Baseclass
{
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "Datadrivenlogin")
    public void verifyDDTTest(String email,String pwd,String exp)
    {
        //validData---->sucess----->Pass
        //validData---->unsucessfull------>Fail

        //Invalid------>Sucessfull----->Fail
        //invalid----->Unsucessfull------>Pass
        //WebDriver driver = null;
          logger.info("***** Starting TC3 LoginDatadriven testing");
        //Homepage POM
        HomepagePOM hp=new HomepagePOM(driver);
        hp.clickmyaccount();
        hp.clicklogin();

        //LoginPOM
        LoginPOM lp=new LoginPOM(driver);
        lp.enteremail(email);
        lp.enterpassword(pwd);
        lp.clicklogin();


        //validation
        MyAccount_Page_POM myacc=new MyAccount_Page_POM(driver);
        boolean myaccounttxt=myacc.myaccountmessageexist();



        //based on condition we write a logic
        if(exp.equalsIgnoreCase("Valid"))
        {
            //Assert.assertTrue(myaccounttxt);
            if(myaccounttxt==true)
            {
                myacc.clicklogout();
                Assert.assertTrue(true);

            }
            else
            {
                Assert.assertTrue(false);
            }
        }
        if(exp.equalsIgnoreCase("invalid"))
        {
            if(myaccounttxt==true)
            {
                myacc.clicklogout();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }
  logger.info("******Finished LoginDataDriven testing");


    }
}
