package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/SearchWithQuotationMArks.feature", glue="map")
public class RunSearchWithQuotationMarks extends AbstractTestNGCucumberTests {

}
