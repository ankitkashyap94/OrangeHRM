package DataProvider;


import PageObjects.LoginTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class CheckDataProvider extends LoginTest {


    @Test(dataProvider = "loginData")
    public void loginPage(String username, String password) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText(), "Dashboard");


    }


    @DataProvider()
    public Object[][] loginData() {

        Object[][] data = new Object[2][2];
        data[0][0] = "admin";
        data[0][1] = "admin123";

        data[1][0] = "admin";
        data[1][1] = "test123";

        return data;

    }


}


