package com.automation.tokotalk;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"com.automation.tokotalk.steps", "com.automation.tokotalk.hooks"},
    plugin = {"pretty", "html:build/result.html"},
    features = "src/test/resources/features",
    stepNotifications = true,
    tags = "@AdminFeatures",
    publish = true
)
public class CucumberRunner {

}
