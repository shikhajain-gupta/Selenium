package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {

    @Test
    void dropDownByIndex() {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Country = driver.findElement(By.id("country"));
        Select dropdown= new Select(Country);
        dropdown.selectByIndex(2);
        //driver.quit();
    }

    @Test
    void dropDownByValue()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Country = driver.findElement(By.id("country"));
        Select dropdown= new Select(Country);
        dropdown.selectByValue("uk");
        //driver.quit();
    }

    @Test
    void dropDownBySelectedText()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement SortedList = driver.findElement(By.id("animals"));
        Select dropdown= new Select(SortedList);
        dropdown.selectByVisibleText("Cat");
        dropdown.selectByVisibleText("Deer");
    }

    @Test
    void BootStrapDropDown()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        WebElement dropDownElement = driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown')]"));
        dropDownElement.click();
    }

    @Test
    void HiddenDropDown()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("Hacker@4321");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text oxd-select-text--active']")).click();
        driver.findElement(By.xpath("//div[@role='listbox']/div/span[text()='operation analyst']")).click();
        driver.quit();

    }
}
