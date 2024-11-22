package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Creat1 {
	//CHROME: Add new assignment accept File submission => OK
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		driver.get("https://school.moodledemo.net/login/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("teacher");
		driver.findElement(By.id("password")).sendKeys("moodle");
		driver.findElement(By.id("loginbtn")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activityExampleLink = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[contains(text(), 'Activity Examples')]]")));
        activityExampleLink.click();
        
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editModeLabel = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Edit mode')]")));
        editModeLabel.click();
        
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addSectionLink = wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.add-section[data-action='addSection']")));
        addSectionLink.click();
        
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editModeLabel1 = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Edit mode')]")));
        editModeLabel1.click();
		
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickNewsection = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'New section')]")));
        clickNewsection.click();
        
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editModeLabel2 = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Edit mode')]")));
        editModeLabel2.click();
		
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Add an activity or resource')]")));
        addButton.click();
        
        WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addAssignment = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//img[@src='https://school.moodledemo.net/theme/image.php/boost/assign/1715018500/monologo']]")));
		addAssignment.click();
        
		WebElement temp = driver.findElement(By.id("id_name"));
		temp.sendKeys("Assignment 3: Automation testing.");
		
		//Được lấy từ Selenium IDE
	    driver.switchTo().frame(0);
	    driver.findElement(By.cssSelector("html")).click();
	    {
	      WebElement element = driver.findElement(By.id("tinymce")); 
	      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'Điền Description'}", element);
	    }
	    driver.switchTo().defaultContent(); 
	    
	    //Được lấy từ Selenium IDE
	    driver.switchTo().frame(1);
	    driver.findElement(By.cssSelector("html")).click();
	    {
	      WebElement element = driver.findElement(By.id("tinymce"));
	      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'Điền Activity instruction'}", element);
	    }
	    driver.switchTo().defaultContent();
	    
	    driver.findElement(By.id("id_allowsubmissionsfromdate_day")).sendKeys("6");
	    driver.findElement(By.id("id_allowsubmissionsfromdate_month")).sendKeys("June");
	    driver.findElement(By.id("id_allowsubmissionsfromdate_year")).sendKeys("2024");
	    
	    driver.findElement(By.id("id_duedate_day")).sendKeys("20");
	    driver.findElement(By.id("id_duedate_month")).sendKeys("June");
	    driver.findElement(By.id("id_duedate_year")).sendKeys("2024");
	    
	    driver.findElement(By.id("id_gradingduedate_day")).sendKeys("26");
	    driver.findElement(By.id("id_gradingduedate_month")).sendKeys("June");
	    driver.findElement(By.id("id_gradingduedate_year")).sendKeys("2024");
	    
	    //driver.findElement(By.id("id_assignsubmission_onlinetext_enabled")).click();
	    driver.findElement(By.id("id_submitbutton")).click();
		
		String at = driver.getTitle();
		String et = "Activity Examples: Recalculating grades | Mount Orange School";
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
