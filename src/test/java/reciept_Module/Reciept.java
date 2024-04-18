package reciept_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Reciept {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	@BeforeMethod
    public WebDriver setUp() throws InterruptedException {
    	  driver = new ChromeDriver();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    	  driver.manage().window().maximize();
    	  driver.get("https://darpanuat.pidilite.com/#/");
    	  driver.getTitle();
    	  action = new Actions(driver);
    	  wait = new WebDriverWait(driver, Duration.ofMinutes(2));
    	  driver.findElement(By.xpath("//input[@id='DBCode']")).sendKeys("0001003897");
    	  driver.findElement(By.xpath("//input[@id='UserID']")).sendKeys("0001003897");
    	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("DarpanPlus@2024");
    	  driver.findElement(By.xpath("//input[@id='Pin']")).sendKeys("203917");
    	  Thread.sleep(6000);
    	  driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
    	  Thread.sleep(6000);
    	  String URL= driver.getCurrentUrl();
    	  Assert.assertEquals(URL, "https://darpanuat.pidilite.com/#/dashboard/index");
    	  return driver;
    	  }
	
	@Test
	public void AddReceipt() throws InterruptedException {
		WebElement TranscationElement = driver.findElement(By.xpath("//a[@class='nav-link menuhide']//span[normalize-space()='Transactions']"));
		action.moveToElement(TranscationElement).perform();
		WebElement Reciept = driver.findElement(By.xpath("//a[normalize-space()='Receipts']"));
		wait.until(ExpectedConditions.elementToBeClickable(Reciept));
		Reciept.click();
		driver.findElement(By.xpath("//button[@class='dms-button dms-primary-button']/u[normalize-space()='V']")).click();
		driver.findElement(By.xpath("//button[@class='dms-button dms-primary-button']/u[normalize-space()='A']")).click();
		Thread.sleep(3000);
	}
	
	@AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

}
