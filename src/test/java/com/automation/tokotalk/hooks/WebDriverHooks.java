package com.automation.tokotalk.hooks;

import com.automation.tokotalk.driver.WebdriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebDriverHooks {

  @Before(value = "@Web")
  public void beforeScenario() {
    WebdriverInit.initialize();
    WebdriverInit.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After(value = "@Web")
  public void afterScenario(Scenario scenario) throws InterruptedException {
    if (scenario.isFailed()) {
      System.out.println("");
      TakesScreenshot screenshot = (TakesScreenshot) WebdriverInit.driver;
      byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
      scenario.attach(imageByte, "image/png", scenario.getId());
      scenario.log("Scenario Fail");
    }
    WebdriverInit.quit();
  }
}
