package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class Alert1 {

    @Test(description="verifying simple alert function", priority = 0, dependsOnMethods = ("confirmationButton"))

    public void simpleAlert(){
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://testautomationpractice.blogspot.com/");
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriver driver= chrome();
        WebElement simpleAlertButton= driver.findElement(By.id("alertBtn"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        driver.quit();

    }


    public  WebDriver chrome(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @Test(description="verifying confirmation alert function", priority = 1)
    public void  confirmationButton(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement confirmAlertButton= driver.findElement(By.id("confirmBtn"));
        confirmAlertButton.click();
        driver.switchTo().alert().dismiss();
        WebElement popuptext = driver.findElement(By.xpath("//p[@id='demo']"));
        String text = popuptext.getText();
        System.out.println(text);
        Assert.assertEquals(text,"You pressed Cancel!");
        driver.quit();
    }


    @Test(description="verifying prompt alert function", priority = 2)
    public void  promptButton(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement promptAlertButton= driver.findElement(By.id("promptBtn"));
        promptAlertButton.click();
        driver.switchTo().alert().sendKeys("test");


//        WebElement popuptext = driver.findElement(By.xpath("//p[@id='demo']"));
//        String text = popuptext.getText();
//        System.out.println(text);
//        Assert.assertEquals(text,"You pressed Cancel!");
        driver.quit();
    }
}
