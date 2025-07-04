package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTable {

    @Test
    void dynamicTable(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        int cellsCount= driver.findElements(By.xpath("//table[@id='taskTable']//tr/td")).size();
       List<WebElement> cells=  driver.findElements(By.xpath("//table[@id='taskTable']//tr/td"));
        int rowsCount= driver.findElements(By.xpath("//table[@id='taskTable']//tr")).size();
        int columnsCount =  driver.findElements(By.xpath("//table[@id='taskTable']//tr/th")).size();

        //to print all values of table
//        for(WebElement a: cells )
//        {
//            System.out.println(a.getText());
//        }

        for(int i=1; i<rowsCount; i++){
            for(int l=1;l<=columnsCount;l++){
                String cellValue= driver.findElement(By.xpath("//table[@id='taskTable']//tr["+i+"]/td["+l+"]")).getText();
                System.out.println(cellValue);
            }
        }

        System.out.println("Chrome CPU: "+ driver.findElement(By.xpath("//strong[@class='chrome-cpu']")).getText());
        System.out.println("firefox-memory: "+ driver.findElement(By.xpath("//strong[@class='firefox-memory']")).getText());
        System.out.println("chrome-network: "+ driver.findElement(By.xpath("//strong[@class='chrome-network']")).getText());
        System.out.println("firefox-disk: "+ driver.findElement(By.xpath("//strong[@class='firefox-disk']")).getText());
        //strong[@class='chrome-cpu']
        //strong[@class='firefox-memory']
        //strong[@class='chrome-network']
        //strong[@class='firefox-disk']

        //to print specific row values
//        for(int j=1;j<=columnsCount;j++){
//            String rowValue=driver.findElement(By.xpath("//table[@id='taskTable']//tr[2]/td["+j+"]")).getText();
//            System.out.println(rowValue);
//        }
driver.quit();
    }
}
