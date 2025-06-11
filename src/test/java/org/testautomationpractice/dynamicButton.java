package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class dynamicButton {

    Alert1 obj= new Alert1();
    WebDriver driver = obj.chrome();
    WebElement dbutton = driver.findElement(By.xpath("//div[@class='widget-content']/button[@onclick='toggleButton(this)']"));
    String buttonText = dbutton.getText();
    System.out.println(buttonText);
    dbutton.click();
    System.out.println(buttonText);
    driver.quit();

}
