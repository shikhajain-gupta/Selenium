package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        WebElement mac = driver.findElement(By.xpath(""));

//div[@class='product-item']/div[@class='details']/div[@class='add-info']/child::div[@class='buttons']/child::button[text()='Add to cart']
    }
}
