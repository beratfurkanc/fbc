package com.apptium.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },
        features = "src/main/resources/com/apptium/features",
        glue = "com/apptium/step_def",
        tags = "@amc",
        dryRun = false
)

public class Runner {}