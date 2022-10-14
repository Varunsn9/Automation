package com.actitime.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.generic.ActitimeLoginandLogout;
import com.actitime.generic.AlertBaseClass;

public class AlertWithOK extends AlertBaseClass {

	@Test
	public void alertWithOK() throws IOException {
		driver.findElement(By.xpath("//button[contains(text(),'alert')]")).click();
		driver.switchTo().alert().accept();
		ActitimeLoginandLogout t=new ActitimeLoginandLogout(); 
		t.takesScreenShot("alertwithok","alertPopUP");
	}
}
