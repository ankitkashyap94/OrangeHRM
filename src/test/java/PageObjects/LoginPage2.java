package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

    WebDriver driver;


    public LoginPage2(WebDriver driver) {
        this.driver = driver;

        //This method will create web element
        PageFactory.initElements(driver, this);
    }

    //Identify WebElements
    @FindBy(css="input[name='username']")
    WebElement username;

    @FindBy(css="input[name='password']")
    WebElement password;

    @FindBy(css="button[type='submit']")
    WebElement submit;


    //LoginPage Elements
    public void initiateLogin(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }



}
