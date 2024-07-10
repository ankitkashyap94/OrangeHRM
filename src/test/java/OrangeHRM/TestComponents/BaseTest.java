package OrangeHRM.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;

    public void initializeDriver() throws IOException {

        Properties props = new Properties();

        FileInputStream fis = new FileInputStream("C:\\Users\\howar\\IdeaProjects\\OrangeHRM\\src\\main\\java\\Resources\\GlobalData.properties");

        props.load(fis);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : props.getProperty("browser");

        if(browserName.contains("chrome")){

            ChromeOptions options = new ChromeOptions();

            if(browserName.contains("headless")){
                options.addArguments("headless");
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

    }


}
