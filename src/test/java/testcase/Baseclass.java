package testcase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Baseclass
{
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

   /*@BeforeClass
    public void init() throws IOException {
        logger= LogManager.getLogger(this.getClass());
        //loading property file from config properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(file);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    */

   @BeforeClass(groups={"Sanity","Regression","DatadrivenLogin"})
    @Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException {
    //public void setup() throws IOException{
        logger= LogManager.getLogger(this.getClass());
        logger.info("Initializing logger");
        //loading property file from config properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
         p=new Properties();
         p.load(file);
       DesiredCapabilities desiredcap = new DesiredCapabilities();
       if(os.equalsIgnoreCase("windows"))
       {
           desiredcap.setPlatform(Platform.WIN11);
       } else
       {
           desiredcap.setPlatform(Platform.LINUX);
       }

       switch (br.toLowerCase()) {
           case "chrome":desiredcap.setBrowserName("chrome");break;
           case "edge":desiredcap.setBrowserName("Microsoftedge");break;
           case "firefox":desiredcap.setBrowserName("firefox");break;
           default:System.out.println("No browser setup");return;
       }
       if(p.getProperty("Execution_env").equalsIgnoreCase("local")) {
           driver = new ChromeDriver();
       } else if (p.getProperty("Execution_env").equalsIgnoreCase("remote")) {
           driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredcap);
       } else {
           throw new RuntimeException("Unknown Environment provided: " + p.getProperty("Execution_env"));
       }
       driver.manage().window().maximize();
      driver.get(p.getProperty("appURL"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

    @AfterClass(groups={"Sanity","Regression","DatadrivenLogin"})
    public void teardown() {
        logger.info("Shut down chrome driver");
        driver.quit();
    }

    public String randomstring() {
        String randomname= RandomStringUtils.randomAlphabetic(5);
        return randomname;
    }
    public String randomnumbertel() {
        String randomnumber= RandomStringUtils.randomAlphanumeric(10);
        return randomnumber;
    }
    public String ramdomalphanumeric() {
        String randomname=RandomStringUtils.randomAlphabetic(3);
        String randomnumber=RandomStringUtils.randomNumeric(3);
        return (randomname+"@"+randomnumber);
    }

    public String CaptureScreen(String sname) {
        String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File Filetargetpath=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage_" + sname + "_" + timestamp + ".png");
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, Filetargetpath);
        } catch (IOException exception) {
            throw new RuntimeException("File not found: ", exception);
        }
        return Filetargetpath.getPath();
    }
}
