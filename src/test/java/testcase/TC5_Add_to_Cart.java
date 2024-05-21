package testcase;

import org.testng.annotations.Test;
import pageObjects.Add_To_Cart_POM;

public class TC5_Add_to_Cart extends Baseclass
{
    @Test
    public void Verify_Add_to_Cart()
    {
        Add_To_Cart_POM ap=new Add_To_Cart_POM(driver);
        ap.searchbox(p.getProperty("searchboxinput"));
        ap.clicksearchicon();
        ap.Searchconfrimmeassage();
        ap.clickmacpro();
        ap.addtocartconfrimmessage();
        ap.click_add_to_Cart();
    }

}
