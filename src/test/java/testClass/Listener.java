package testClass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.TestNgBaseClass;
import utility.Utility;

public class Listener extends TestNgBaseClass implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility.screenshotCapture(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Tc is fail...", true);
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("Tc is faile bcoz of timeout...", true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC successfully run...", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("TC executions is Start...", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Tc"+result+"is skipped", true);
	}

}
