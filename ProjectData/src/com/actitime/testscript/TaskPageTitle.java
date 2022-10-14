package com.actitime.testscript;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.ActitimeLoginandLogout;

public class TaskPageTitle extends ActitimeLoginandLogout {

@Test
public void titlePageTitle() throws IOException {
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[text()='Tasks']")).click();
	wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.titleContains("Task"));
	String eTitle = driver.getTitle();
	String aTitle="actiTIME - Task List";
	Assert.assertEquals(aTitle, eTitle);
	Reporter.log("title is "+eTitle,true);
	TakesScreenshot t=(TakesScreenshot) driver;
	File src= t.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/TaskPageTitle.png");
	FileUtils.copyFile(src, dest);
	Reporter.log("TaskPageTitle");
}
}
