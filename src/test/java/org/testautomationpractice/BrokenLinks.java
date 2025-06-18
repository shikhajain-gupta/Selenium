package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    @Test
    void brokenLinks() throws IOException {
        String s;
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> links= driver.findElements(By.xpath("//div[@class='content']//a"));

        for(WebElement a: links) {
            s = a.getAttribute("href");
            System.out.println(s);
            try {
                if (s != null) {
                    URL url = new URL(s);
                    HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                    connect.setRequestMethod("HEAD");
                    if (connect.getResponseCode() >= 400) {
                        System.out.println(s + "  is broken link with response code  " + connect.getResponseCode());
                    } else {
                        System.out.println(s + "  is not broken link with response code  " + connect.getResponseCode());
                    }
                }
            }
            catch (Exception e){
                System.out.println("Exception for URL is  " + e.getMessage());
            }
        }

        driver.quit();
    }
}