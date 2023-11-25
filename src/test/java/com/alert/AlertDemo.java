package com.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AlertDemo {
	  WebDriver driver;
	  
	  By alertButton= By.xpath("//button[text()=\"Click for JS Alert\"]");
	  
	  By confirmButton= By.xpath("//button[text()=\"Click for JS Confirm\"]");
	  
	  By promptButton= By.xpath("//button[text()=\"Click for JS Prompt\"]");
	  
	  By successfulMessage= By.xpath("//*[text()=\"You successfully clicked an alert\"]");
	  
	  By okMessage= By.xpath("//*[text()=\"You clicked: Ok\"]");
	  
	  By cancelMessage= By.xpath("//*[text()=\"You clicked: Cancel\"]");
	  
	  By textMessage= By.xpath("//*[text()=\"You entered: Hi\"]");
	 @BeforeTest
	    public void testBrowser() {
	       WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();   
	        driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/javascript_alerts");   
	          
	    }

	 @Test
	 public void test() throws Exception {
		 
		 driver.findElement(alertButton).click();
		 //accept alert
		 driver.switchTo().alert().accept();
		 //validation for succesful meassage
		 Assert.assertTrue(driver.findElement(successfulMessage).isDisplayed());
		 
		 driver.findElement(confirmButton).click();
		 //accept alert
		 driver.switchTo().alert().accept();
		 //validation for ok meassage
		 Assert.assertTrue(driver.findElement(okMessage).isDisplayed());
		 
		 
		 driver.findElement(confirmButton).click();
		 //dismiss alert
		 driver.switchTo().alert().dismiss();
		 //validation for cancel meassage
		 Assert.assertTrue(driver.findElement(cancelMessage).isDisplayed());
		 
		 
		 driver.findElement(promptButton).click();
		 //enter text
		 driver.switchTo().alert().sendKeys("Hi");
		 
		 //accept alert
		 driver.switchTo().alert().accept();
		 //validation for cancel meassage
		 Assert.assertTrue(driver.findElement(textMessage).isDisplayed());
	 }
	 
	 @AfterTest
	 public void closeTest() {
		driver.quit();
}
}