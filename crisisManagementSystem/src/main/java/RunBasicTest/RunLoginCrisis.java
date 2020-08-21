package RunBasicTest;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/BasicTestFeatures/LoginCrisis.feature", glue="BasicTests")
public class RunLoginCrisis extends AbstractTestNGCucumberTests {
	
}
