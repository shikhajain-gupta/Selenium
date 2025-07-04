package org.testautomationpractice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadDataExcel {

    @Test
    public void readExcel() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        File f= new File("C:\\Users\\deepa\\IdeaProjects\\SeleniumLearn\\src\\test\\java\\org\\testautomationpractice\\SeleniumData.xlsx");
        FileInputStream fis= new FileInputStream(f);
        XSSFWorkbook workbook= new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheetAt(0);

        Iterator<Row> rowIterator= sheet.iterator();
        rowIterator.next();

        Row row;
        Cell name;
        Cell email;
        Cell phono;

        while(rowIterator.hasNext()){
row= rowIterator.next();
name=row.getCell(0);
email=row.getCell(1);
phono=row.getCell(2);

            String name1 = name.toString();
            String email1= email.toString();
            String phno1=phono.toString();

            WebElement name2 = driver.findElement(By.id("name"));

            WebElement email2 = driver.findElement(By.id("email"));

            WebElement phone2 = driver.findElement(By.id("phone"));

           name2.clear();
            name2.sendKeys(name1);
            email2.clear();
            email2.sendKeys(email1);
            phone2.clear();
            phone2.sendKeys(phno1);

        }
        workbook.close();
        fis.close();
        driver.quit();

    }
}
