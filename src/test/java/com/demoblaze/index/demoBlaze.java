package com.demoblaze.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class demoBlaze {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.className("hrefch"));
        for (WebElement element : elements) {
            System.out.println(element.getAttribute("href"));
        }
        System.out.println("no of links on the page are: " + elements.size());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement image : images) {
            System.out.println(image.getAttribute("src"));
        }
        System.out.println("no of images on the page are: " + images.size());

        WebElement linkText = driver.findElement(By.linkText("Samsung galaxy s6"));
        linkText.click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (url.equals("https://www.demoblaze.com/prod.html?idp_=1"))
        {
            System.out.println("Clicking on Samsung galaxy s6 link is working fine");

        }

        driver.navigate().back();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("1520")).click();
        String url1 = driver.getCurrentUrl();
        System.out.println(url1);
        driver.quit();
    }
}