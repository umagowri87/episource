package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;			

/*
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;
*/
//import cucumber.api.CucumberOptions;

/*  -----Extended Cucumber options used by Mkolisnyk library-----
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
=======
/*@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
>>>>>>> branch 'master' of https://github.com/EpisourceLLC/MRR_MCC_Automation
retryCount = 3,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
//coverageReport = true,
jsonUsageReport = "target/cucumber-usage.json",
usageReport = true,
toPDF = true,
excludeCoverageTags = {"@flaky" },
includeCoverageTags = {"@passed" },
<<<<<<< HEAD
outputFolder = "target")
*/

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports/report.html" },
        monochrome = true,
        dryRun=false
        
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}