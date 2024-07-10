package ExtentReportsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class BasicExtentReports {

    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void configReport() {

        //Set Reporter Configuration
        htmlReporter = new ExtentSparkReporter("D:\\OrangeHRM\\ExtentReport\\ExtentReportDemo.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //Set Environment details
        extent.setSystemInfo("Machine", "TestPC1");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("User", "Prachi");
        extent.setSystemInfo("Browser", "Chrome");

        //Config to change Look&Feel
        htmlReporter.config().setDocumentTitle("Demo Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");


    }

    @Test
    public void launchBrowser() {
        //Create Test
        test = extent.createTest("Launch Browser and Open Url");
        Assert.assertTrue(true); //test Passed
    }

    @Test
    public void verifyTitle() {
        //Create Test
        test = extent.createTest("VerifyTitle");
        Assert.assertTrue(false); //test Failed
    }

    @Test
    public void verifyLogo() {
        //Create Test
        test = extent.createTest("Verify Logo");
        Assert.assertTrue(true); //test Passed
    }

    @Test
    public void verifyEmail() {
        //Create Test
        test = extent.createTest("Verify email");
        throw new SkipException("Skipping this test with Exception");
    }

    @Test
    public void verifyUsername() {
        //Create Test
        test = extent.createTest("Verify Username");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void getTestResult(ITestResult result) {
        //Create Test
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
            test.fail(result.getThrowable()); //Log console data
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed", ExtentColor.GREEN));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skipped", ExtentColor.YELLOW));
        }
    }

    //Important to generate report
    @AfterTest
    public void tearDown(){
        extent.flush();
    }

}
