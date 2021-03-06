package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.util.Base.TestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features="src/test/java/com/bdd/feature/Automate.feature",
		glue={"com/automation/stepdefination"},
		plugin={"pretty","com.cucumber.listener.ExtentCucumberFormatter:"},
		tags={"@CartTest,@MenuTest,@ProductTest,@RegistrationTest"},
		monochrome=true,
		dryRun=false
		)

public class AutomationRunner extends TestBase{
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass() throws Exception{
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups="cucumber", description="Runs Cucumber Features", dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterClass(alwaysRun=true)
	public void setUpClose(){
		if(driver!=null){
		driver.quit();
		}
		testNGCucumberRunner.finish();
	}
	
	
	
	
	
	
	
	
	
}
