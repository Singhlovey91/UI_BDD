package runnerPackage;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true, glue = { "stepdefinition" },  dryRun= false, 

			features = "src/test/java/feature",

			//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/PrepaymentCharge.html", "pretty", "html:target/htmlreports",
			//	"junit:target/cucumber-reports/PrepaymentCharge.xml", "json:target/cucumber-reports/Cucumber.json"},
			monochrome = true)

public class TestRunner {
	

}
