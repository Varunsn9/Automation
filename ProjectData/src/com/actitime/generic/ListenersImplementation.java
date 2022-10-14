package com.actitime.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation extends ActitimeLoginandLogout implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getName();
		ActitimeLoginandLogout tm=new ActitimeLoginandLogout();
		try {
			tm.takesScreenShot("SuccessTest",methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName();
		ActitimeLoginandLogout tm=new ActitimeLoginandLogout();
		try {
			tm.takesScreenShot("FailedTest",methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getName();
		ActitimeLoginandLogout tm=new ActitimeLoginandLogout();
		try {
			tm.takesScreenShot("SkippedTest",methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		}

	@Override
	public void onStart(ITestContext context) {
		}

	@Override
	public void onFinish(ITestContext context) {
		}

}
