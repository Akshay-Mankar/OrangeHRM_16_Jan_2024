package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"AllFeatureFiles/OrangeHRMTest.feature"},
		glue= {"StepDefination"},
		dryRun = false
		)
public class RunnerTest {

}
