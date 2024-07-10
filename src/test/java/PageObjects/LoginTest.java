package PageObjects;

import DataProvider.CheckDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


        Object temp;


        //Creating object for loginPage
        LoginPage loginPage = new LoginPage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);

        //Creating object for data provider for getting login data
        CheckDataProvider cdp = new CheckDataProvider();
        Object[][] data = cdp.loginData();

//        Running loop for extracting data from dataProvider class
//
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length; j++) {
//                temp = data[i][j];
//            }
//
//        }


        //Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //calling method from another class
        loginPage.initiateLogin("Admin", "admin123");
        loginPage2.initiateLogin("Admin", "admin23");
    }
}
