package TakesScreenShotMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot  {
static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
}
@Test
public void screenShot() throws IOException {
WebDriver driver=new ChromeDriver();
TakesScreenshot t=(TakesScreenshot) driver;
driver.get("https://www.google.com/");
File src=t.getScreenshotAs(OutputType.FILE);
File decs=new File("./screenShot/screenShot.png");
FileUtils.copyFile(src, decs);
driver.close();
}
}
