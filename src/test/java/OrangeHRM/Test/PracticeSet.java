package OrangeHRM.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeSet {

    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;



    @BeforeTest
    public void generateReports(){

        htmlReporter = new ExtentSparkReporter("D:\\OrangeHRM\\ExtentReport\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


       //Add system configurations
        extent.setSystemInfo("Machine","TestPC");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("User", "Ankit");
        extent.setSystemInfo("Browser", "Chrome");

        //Setting Test Environment
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");
        htmlReporter.config().setDocumentTitle("Demo Report");

    }


    @Test(dataProvider = "LoginDetails")
    public void Login(String username, String password) {

        test = extent.createTest("VerifyLogin");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.navigate().to("https://www.google.com");
//        driver.navigate().back();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText(), "Dashboard");
    }

    @DataProvider(name="LoginDetails")
    public Object[][] loginData(){

        Object[][] data = new Object[2][2];

        data[0][0] = "admin";
        data[0][1] = "admin123";

        data[1][0] = "admin123";
        data[1][1] = "adminadmin";

        return data;
    }

    @AfterTest
    public void tearDown(){
        extent.flush();
    }

}
