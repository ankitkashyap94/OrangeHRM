package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.cssSelector("input[name='username']");
    By password = By.cssSelector("input[name='password']");
    By submit = By.cssSelector("button[type='submit']");

    public void initiateLogin(String user, String pass){

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }

}
