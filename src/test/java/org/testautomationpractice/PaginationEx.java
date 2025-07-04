package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PaginationEx {

    @Test
    void pagination() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        int count = driver.findElements(By.xpath("//ul[@class='pagination']//a")).size();
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
        //table[@id='productTable']//tr

        for(int i=1;i<=count;i++){
            for(int j=1;j<rowCount;j++)
            {
                driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[4]/input")).click();
                Thread.sleep(1000);
            }
            driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]/a")).click();
            Thread.sleep(2000);
        }

driver.quit();
    }
}
