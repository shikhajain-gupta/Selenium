package org.testautomationpractice.testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButton {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement male = driver.findElement(By.xpath("//label[text()='Male']"));
        Thread.sleep(3000);
        male.click();
        WebElement female = driver.findElement(By.xpath("//label[text()='Female']"));
        female.click();
        Thread.sleep(3000);
        driver.quit();


    }
}