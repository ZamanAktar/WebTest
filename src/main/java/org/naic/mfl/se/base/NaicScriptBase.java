package org.naic.mfl.se.base;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.naic.mfl.se.utilities.FileVariable;
import org.naic.mfl.se.utilities.ResourceFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class NaicScriptBase extends ScriptBase{

private ApplicationController appController = null;
	
	@BeforeMethod(alwaysRun = true)
	@Override
	@Parameters({"browser"})
	public void setUp(@Optional(value="chrome") String browser) throws MalformedURLException{
		super.setUp(browser);
		
		driver.manage().window().maximize();
		driver.navigate().to(ResourceFactory.getInstance().getProperty("APP_URL").toString());
		
	}
	
	public ApplicationController appController(){
		if(appController == null){
			appController =new ApplicationController(driver);
		}
		return appController;
	}
	
	
	@AfterMethod(alwaysRun=true)
	@Override
	public void tearDown(ITestResult result){
		super.tearDown(result);
		appController = null;
	}
	
	public HashMap<String, String > readTextFileExternal (String varFilePath, String sectionHead, String variation){
		HashMap<String, String > getVariables = null;
		getVariables = FileVariable.getVariables(varFilePath, sectionHead, variation);
		return getVariables;
	}
}
