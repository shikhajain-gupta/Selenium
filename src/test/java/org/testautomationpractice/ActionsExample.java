package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
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
    void rightClick() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions act = new Actions(driver);
        Action myact = act.contextClick(rightClick).click().build();
        myact.perform();
        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
        edit.click();
        driver.switchTo().alert().accept();
        driver.quit();
    }

    @Test
    void dragDrop() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions act = new Actions(driver);
        act.dragAndDrop(drag, drop).perform();
        driver.quit();
    }


    @Test
    void keyBoardActions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement textbox1 = driver.findElement(By.id("inputText1"));
        WebElement textbox2 = driver.findElement(By.id("inputText2"));
        Actions act = new Actions(driver);
        act.sendKeys(textbox1,"Hello World");
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        Assert.assertEquals(textbox1.getText(),textbox2.getText());

        driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement register = driver.findElement(By.xpath("//div[@class='css-vb6e92']/button[text()='Register']"));
        register.click();
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("shikhatest30");
        Thread.sleep(2000);
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.sendKeys("shikhatest30").perform();
        Thread.sleep(2000);
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.sendKeys("shikhatest30").perform();
        Thread.sleep(2000);
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.click().perform();
        driver.quit();


    }

    @Test
    void sliderExample()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions act = new Actions(driver);

        WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
        WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
        System.out.println("minslider" + minSlider.getLocation());
        System.out.println("maxslider" + maxSlider.getLocation());
        act.dragAndDropBy(minSlider,100,0).perform();
        System.out.println("minslider" + minSlider.getLocation());
        act.dragAndDropBy(maxSlider,-50,0).perform();
        System.out.println("maxslider" + maxSlider.getLocation());
        driver.quit();

    }
}