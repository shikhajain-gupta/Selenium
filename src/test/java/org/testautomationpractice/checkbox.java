package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class checkbox {

    @Test

    public void check() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List< WebElement> box = driver.findElements(By.xpath(" //input[@id='sunday']/ancestor::div[@class='form-group']/descendant::div/input[@class='form-check-input']"));

        for(WebElement a : box)
        {
            a.click();
            System.out.println(a.getAttribute("value") + "is selected");
        }
driver.quit();
    }
}
