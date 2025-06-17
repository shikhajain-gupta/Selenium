package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionsExample {

    @Test
    void mouseHover() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement pointMe = driver.findElement(By.xpath("//button[text()='Point Me']"));
        WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));
        Actions act = new Actions(driver);
        act.moveToElement(pointMe).moveToElement(mobiles).click().build().perform();
        driver.quit();

    }


    @Test
    void doubleClick() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement copyText = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        Actions act = new Actions(driver);
        act.doubleClick(copyText).perform();
        driver.quit();
    }

    @Test
    void rightClick()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions act=new Actions(driver);
        Action myact = act.contextClick(rightClick).click().build();
        myact.perform();
        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
        edit.click();
        driver.switchTo().alert().accept();
        driver.quit();
    }

    @Test
    void dragDrop()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions act= new Actions(driver);
        act.dragAndDrop(drag,drop).perform();
        driver.quit();
    }
}