package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submit1 {
	//MICROSOFT EDGE: Submit assignment with File
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
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
        
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe")));
        driver.switchTo().frame(iframeElement);
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("D:\\BÁCH KHOA\\HK 232\\Kiểm tra phần mềm\\BTL\\BTL3\\Project #3 description.pdf");
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
