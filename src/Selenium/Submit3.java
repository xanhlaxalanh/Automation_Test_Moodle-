package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submit3 {
	//CHROME: submit only text 
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		driver.get("https://school.moodledemo.net/login/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("moodle");
		driver.findElement(By.id("loginbtn")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activityExampleLink = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[contains(text(), 'Activity Examples')]]")));
        activityExampleLink.click();
        
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickSection = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[contains(text(), 'New section')]]")));
        clickSection.click();
        
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickAssignment = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[contains(text(), 'Assignment 3: Automation testing.')]]")));
        clickAssignment.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add submission')]")));
	    submitButton.click();
        
//        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe")));
//        driver.switchTo().frame(iframeElement);
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
//        fileInput.sendKeys("D:\\BÁCH KHOA\\HK 232\\Kiểm tra phần mềm\\BTL\\BTL3\\Project #3 description.pdf");
//        driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame(0);
	    driver.findElement(By.cssSelector("html")).click();
	    {
	      WebElement element = driver.findElement(By.id("tinymce"));
	      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p><span id=\"_mce_caret\" data-mce-bogus=\"1\" data-mce-type=\"format-caret\">﻿Điền submit</span><br data-mce-bogus=\"1\"></p>'}", element);
	    }
	    driver.switchTo().defaultContent();
        
        driver.findElement(By.id("id_submitbutton")).click();
        
        String at = driver.getTitle();
		String et = "Activity Examples: Assignment 3: Automation testing. - Edit submission | Mount Orange School";
		System.out.println(at);
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Successful");
		}
		else 
		{
			System.out.println("Test Failure");
		}
	}

}
