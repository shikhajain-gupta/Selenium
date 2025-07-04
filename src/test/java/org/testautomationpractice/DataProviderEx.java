package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderEx {

//    @Test(dataProvider= "testdata")
//    public void readData(Object[][] data) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://testautomationpractice.blogspot.com/");
//
//        WebElement name1 = driver.findElement(By.id("name"));
//
//        WebElement email1 = driver.findElement(By.id("email"));
//
//        WebElement phone1 = driver.findElement(By.id("phone"));
//
//
//        for(Object[] row:data)
//        {
//            String name= (String) row[0];
//            String pass= (String) row[1];
//            String phone= (String) row[2];
//            name1.sendKeys(name);
//            email1.sendKeys(pass);
//            phone1.sendKeys(phone);
//            Thread.sleep(2000);
//            name1.clear();
//            email1.clear();
//            phone1.clear();
//        }
//    }

    @Test(dataProvider= "testdata2")
    public void readData(String name, String email,String phno) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement name1 = driver.findElement(By.id("name"));

        WebElement email1 = driver.findElement(By.id("email"));

        WebElement phone1 = driver.findElement(By.id("phone"));

        name1.sendKeys(name);
        email1.sendKeys(email);
        phone1.sendKeys(phno);

    }

//dataprovider returns the array in form of object[][] only
    //regular string or integar arrays are not allowed
            //also it can not return object[] unless it is passed through iterator<object[]>
    @DataProvider
    public Iterator<Object[][]> testdata()
    {
        List<Object[][]> obj= new ArrayList<>();
        obj.add(new Object[][]{{"Shikha","gupta","123456789"},{"shikha1","gupta1","7894651358"}});
        obj.add(new Object[][]{{"mishka","jain","9896568752"},{"mishka1","jain1","635694164"}});
        return obj.iterator();
    }


    @DataProvider
    public Object[][] testdata2()
    {
        return new Object[][]{
                {"111", "222","333"},
                {"555", "666", "777"}
        };
    }

}
