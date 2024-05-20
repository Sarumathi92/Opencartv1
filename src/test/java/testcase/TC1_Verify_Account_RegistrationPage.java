package testcase;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomepagePOM;
import pageObjects.RegesiterPOM;

public class TC1_Verify_Account_RegistrationPage extends Baseclass {

    @Test(groups="Regression")
    public void verifyaccount_Register_Page() {
        try {
            logger.info(" Starting Verify_Account_RegistrationPage_TC1    ");
            HomepagePOM hp = new HomepagePOM(driver);
            hp.clickmyaccount();
            logger.info(" Clicking my account   ");
            hp.clickregister();
            logger.info("   Clicking register  ");

            RegesiterPOM rp = new RegesiterPOM(driver);
            rp.firstname(randomstring().toUpperCase());
            logger.info("  Enter firstname");
            rp.lastname(randomstring().toUpperCase());
            logger.info(" Enter lastname");
            rp.email(randomstring() + "@gmail.com");
            logger.info(" enter gmail ");

            rp.telephone(randomnumbertel());
            logger.info("Enter phonenumber");
            String password = ramdomalphanumeric();

            rp.password(password);
            logger.info("Enter password");
            rp.confirmpwd(password);
            logger.info("Enter confirmpassword");
            rp.agreepolicy();
            logger.info("Click privacypolicy");
            rp.butcontinue();
            logger.info("enter continue");
            //validation
            String responseconfrimmess = rp.confrimmessage();

            Assert.assertEquals(responseconfrimmess, "Your Account Has Been Created!");
        }
        catch (Exception e)
        {

            logger.debug("Debug log");

            //logger.error("Error message");
            // Assert.fail();
        }
        logger.info("  finished  Verify_Account_RegistrationPage_TC1   ");


    }
}

