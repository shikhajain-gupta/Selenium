package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class search {

    @Test
   // public static void main(String[] args) throws InterruptedException {
        public void searchText () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
        search.sendKeys("selenium");
        WebElement searchButton = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
        searchButton.click();
        //Thread.sleep(3000);

        //List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/descendant::a"));
        WebDriverWait searchWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> searchResults= searchWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/descendant::a")));


        for (WebElement a : searchResults) {
            System.out.println(a.getText());
        }

        driver.quit();
    }
}
//}