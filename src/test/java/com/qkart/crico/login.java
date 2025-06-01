package com.qkart.crico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class login {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");

       // Thread.sleep(3000);


        WebElement register = driver.findElement(By.xpath("//div[@class='css-vb6e92']/button[text()='Register']"));

        //div/div/div[1]/div[3]/button[2]
        //div[@class='css-vb6e92']/child::button[text()='Register']
        //div[@class='css-vb6e92']/button[text()='Register']

        register.click();
        //Thread.sleep(3000);

        driver.findElement(By.id("username")).sendKeys("shikhatest7");
        //Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("shikhatest7");
       // Thread.sleep(1000);
        driver.findElement(By.id("confirmPassword")).sendKeys("shikhatest7");
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form css-ikzlcq']/button[1]")).click();
        //div[@class='form css-ikzlcq']/button[1]
        //Thread.sleep(3000);

        String url = driver.getCurrentUrl();
        if (url.contains("login")) {
            System.out.println("You are registered successfully");
            driver.findElement(By.id("username")).sendKeys("shikhatest7");
           // Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("shikhatest7");
           // Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='form css-ikzlcq']/button")).click();
           // Thread.sleep(3000);
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

            //for(WebElement img : imageText)
            //{
            //  System.out.println(img.getText());
            //}

            driver.quit();
        } else {
            System.out.println("Login first");
        }

    }
}
