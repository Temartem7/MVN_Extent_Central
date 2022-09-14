package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("Browser setup starting");
		if(System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		}else if(System.getProperty("browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.get("https://www.google.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
