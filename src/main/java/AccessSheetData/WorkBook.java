package AccessSheetData;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;


public class WorkBook {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        //Excel-->WorkBook-->Sheet-->Row-->Cell

       /*XSSFWorkbook wb = new XSSFWorkbook();
       XSSFSheet sheet = new XSSFSheet();
       XSSFRow row = new XSSFRow();
       XSSFCell cell = new XSSFCell();*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //Create an object to file class to access file.
        File excelFile = new File("D:\\LoginData.xlsx");

        //Create object of FileInputStream to read data from file.
        FileInputStream fis = new FileInputStream(excelFile);


        //Now process of access excel
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //Access Sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Get total row count
        int totalRows = sheet.getLastRowNum() + 1;
        System.out.println(totalRows);

        //Get Total Cell count
        int totalCells = sheet.getRow(0).getLastCellNum();
        System.out.println(totalCells);

        for (int cr = 0; cr < totalRows; cr++) { //cr-> currentRow (Read rows)
            for (int cc = 0; cc < totalCells; cc++) { //cc-> currentCell (Read cells or column)




                //Launch Chrome Browser
                driver.get("https://www.saucedemo.com");
                driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(cr).getCell(0).toString());
                driver.findElement(By.id("password")).sendKeys(sheet.getRow(cr).getCell(1).toString());
                driver.findElement(By.id("login-button")).click();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



//                System.out.print(sheet.getRow(cr).getCell(cc).toString());
//                System.out.print("\t");

            }

            

        }
        workbook.close();
        driver.quit();

    }
}
