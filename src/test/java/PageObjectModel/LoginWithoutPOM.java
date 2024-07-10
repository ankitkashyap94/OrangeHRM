package PageObjectModel;

import DataProvider.CheckDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.impl.io.IdentityOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;


public class LoginWithoutPOM extends CheckDataProvider {

    public static void main(String[] args) {

        Object temp;

        CheckDataProvider cdp = new CheckDataProvider();
        Object[][] newData = cdp.loginData();

        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData.length; j++) {

                temp = newData[i][j];

            }

        }


    }

}
