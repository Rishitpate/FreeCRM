package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;


public class TestUtil extends TestBase{
	
	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait = 5;
	
	public static String testdatapath = ("C:\\Selenium WorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMtestdata.xlsx");
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	
	

}
