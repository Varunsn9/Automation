package com.actitime.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.ActitimeLoginandLogout;

public class HomePageTitle extends ActitimeLoginandLogout{
	@Test
	public void title() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Enter"));
		String etitle="actiTIME - Enter Time-Track";
		String atitle = driver.getTitle();
		Reporter.log("actual title is "+atitle,true);
		Reporter.log("expected title is "+etitle,true);
		Assert.assertEquals(atitle, etitle);
		TakesScreenshot t=(TakesScreenshot) driver;
		File src= t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/HomePageTitle.png");
		FileUtils.copyFile(src, dest);
	}
}
