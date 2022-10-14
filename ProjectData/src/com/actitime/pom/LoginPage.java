package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(id="username")
private WebElement untbx;
@FindBy(name="pwd")
private WebElement pwtbx;
@FindBy(xpath="")
private WebElement lgtbx;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void setUser(String un, String pw) {
	untbx.sendKeys(un);
	pwtbx.sendKeys(pw);
	lgtbx.click();
}


}
