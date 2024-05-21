package testcase;

import org.testng.annotations.Test;
import pageObjects.HomepagePOM;
import pageObjects.Search_InputBoxPOM;

public class TC4_Search_InputBox extends Baseclass
{
    @Test
    public void Verify_Search_InputBox()
{
    Search_InputBoxPOM sp=new Search_InputBoxPOM(driver);
        sp.searchbox(p.getProperty("searchboxinput"));
        sp.clicksearchicon();

        //validation
    sp.Searchconfrimmeassage();

}

}
