package com.actitime.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Anime {
static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
	@Test
public void animeMethod() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Alerts.html");
	driver.findElement(By.xpath("/(//button/../../../../../div[1]/div/div/div/div/div/button)[1]")).click();
	driver.switchTo().alert().accept();
	driver.close();
}
}
