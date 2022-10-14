package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ActitimeLoginandLogout {
public static WebDriver driver;
public static FileInputStream fis;
Properties p;
public static WebDriverWait wait;
static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
}
	@BeforeTest
	public void openBrowser() throws IOException {
		fis=new FileInputStream("./data/url.property");
		p=new Properties();
		p.load(fis);
		String url = p.getProperty("actitimeurl");
		Reporter.log(url);
		driver=new ChromeDriver();
		driver.get(url);
		Reporter.log("Opened Browser",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		fis=new FileInputStream("./data/adminData.property");
		p=new Properties();
		p.load(fis);
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Reporter.log("logged into the application",true);
	}
	@AfterMethod
	public void logout() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out of the application",true);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		Reporter.log("closed the browser",true);
	}
	public void takesScreenShot(String folder, String fileName) throws IOException {
	TakesScreenshot t=(TakesScreenshot) driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	File dest=new File("./"+folder+"/"+fileName+".png");
	FileUtils.copyFile(src, dest);
	}
}
