package com.actitime.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.ActitimeLoginandLogout;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class ReportPageTitle extends ActitimeLoginandLogout{

	@Test
	public void reportPageTitle(){
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Enter"));
		driver.findElement(By.xpath("//div[.='Reports']")).click();
		wait.until(ExpectedConditions.titleContains("Report"));
		String actualTitle=driver.getTitle();
		String expectedTitle="actiTIME - Reports Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
