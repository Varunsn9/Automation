package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AlertBaseClass extends ActitimeLoginandLogout {


static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
	@BeforeTest
public void openBrowser() throws IOException {
		fis=new FileInputStream("./data/url.property");
	Properties p=new Properties();
	p.load(fis);
	String url = p.getProperty("alerturl");
		driver= new ChromeDriver();
	driver.get(url);
}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
