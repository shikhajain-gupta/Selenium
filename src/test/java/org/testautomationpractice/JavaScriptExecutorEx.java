package org.testautomationpractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptExecutorEx {

    @Test
    void JavaScriptExecutorSendKey()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','test')", name);


    }

    @Test
    void JSExecutorClick()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement newTabButton = driver.findElement(By.xpath("//button[text()='New Tab']"));

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", newTabButton);

    }

    @Test
    void JSScrollByPixel()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       JavascriptExecutor js= (JavascriptExecutor)driver;
        System.out.println(js.executeScript("return window.pageYOffset"));
        js.executeScript("window.scrollBy(0,1000)");
        System.out.println(js.executeScript("return window.pageYOffset"));
    }

    @Test
    void JSScrollTillElementVisible()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement fileUpload  = driver.findElement(By.id("singleFileInput"));
        js.executeScript("arguments[0].scrollIntoView();",fileUpload);
    }

    @Test
    void JSScrollTillEnd() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
}
