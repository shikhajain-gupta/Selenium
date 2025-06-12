package org.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class dynamicButton {

    @Test
    public void dynamicButton() {
        Alert1 obj = new Alert1();
        WebDriver driver = obj.chrome();
        WebElement dbutton = driver.findElement(By.xpath("//div[@class='widget-content']/button[@onclick='toggleButton(this)']"));
        //String buttonText = dbutton.getText();

        for(int i=0; i<=5;i++) {
            System.out.println(i+1+ "iteration");
            System.out.println(dbutton.getText());
            dbutton.click();
            System.out.println(dbutton.getText());
            dbutton.click();
        }
        driver.quit();

    }
}