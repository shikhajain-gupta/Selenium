package com.qkart.crico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class loginWaitsAsserts {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");

        WebElement register = driver.findElement(By.xpath("//div[@class='css-vb6e92']/button[text()='Register']"));
        register.click();
        driver.findElement(By.id("username")).sendKeys("shikhatest19");
        driver.findElement(By.id("password")).sendKeys("shikhatest19");
        driver.findElement(By.id("confirmPassword")).sendKeys("shikhatest19");
        driver.findElement(By.xpath("//div[@class='form css-ikzlcq']/button[1]")).click();


        //adding explicit wait since implicit wait does not work on url changes
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlMatches("https://crio-qkart-frontend-qa.vercel.app/login"));

        String url = driver.getCurrentUrl();
        //Assert.assertEquals(url, "https://crio-qkart-frontend-qa.vercel.app/login");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(url, "https://crio-qkart-frontend-qa.vercel.app/login");

        System.out.println("You are registered successfully");
        driver.findElement(By.id("username")).sendKeys("shikhatest19");
        driver.findElement(By.id("password")).sendKeys("shikhatest19");
        driver.findElement(By.xpath("//div[@class='form css-ikzlcq']/button")).click();
        String name = driver.findElement(By.xpath("//div[@class='css-vb6e92']/p")).getText();
        System.out.println(name + " is logged in");


        //to count images on page

        //List<WebElement> images = driver.findElements(By.cssSelector(".MuiCardMedia-root.MuiCardMedia-media.MuiCardMedia-img.css-rhsghg"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='App']/descendant::img"));
        System.out.println("total no of images on this page are :" + images.size());

        //to print product names in console

        //List<WebElement> imageText = driver.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-yg30e6"));
        for (WebElement imageText : images) {
            String text = imageText.getAttribute("alt");
            System.out.println("image text is " + text);
        }
        sa.assertAll();
        driver.quit();

    }
}

