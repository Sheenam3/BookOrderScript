package com.soulfulcreators.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BookOrder {
	
	WebDriver driver;
	JavascriptExecutor exe;
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();  //managing browser commands using manage method
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // wait while page is loading  elements on page because page takes time depending upon server and net speed 
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.com");
			searchBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchBook() {
		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Robin Sharma"); // typing 
			driver.findElement(By.className("nav-input")).click(); //In case you get an exception in clicking make it sleep for a few secs Thread.sleep(4000); and use thread try catch
			exe = (JavascriptExecutor)driver;
			exe.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.xpath("//span[contains(text(), 'Motivational Self-Help')]")).click();
			driver.findElement(By.xpath("//h2[contains(text(), 'The Monk Who Sold His Ferrari: A Remarkable Story About Living Your Dreams')]")).click();
			driver.findElement(By.id("one-click-button")).click();
			driver.findElement(By.name("email")).sendKeys("Your Email");
			driver.findElement(By.name("password")).sendKeys("Password");
			driver.findElement(By.id("signInSubmit")).click(); 

			
		
	}
	
	public static void main(String[] args) {
		BookOrder myobj = new BookOrder();
		myobj.invokeBrowser();
	}

}
