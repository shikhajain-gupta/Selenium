package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowSwitch {
@Test
    void windowSwitch(){
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://testautomationpractice.blogspot.com/");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    String currentWindow= driver.getWindowHandle();
    driver.findElement(By.xpath("//button[text()='New Tab']")).click();
   Set<String> windowHandles = driver.getWindowHandles();

   for(String s: windowHandles) {
       if (!s.equals(currentWindow)) {
           driver.switchTo().window(s);
           System.out.println(driver.getCurrentUrl());
       }
   }
driver.close();
}
}
