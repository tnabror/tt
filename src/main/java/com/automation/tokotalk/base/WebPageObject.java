package com.automation.tokotalk.base;

import com.automation.tokotalk.driver.WebdriverInit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebPageObject {

  //getDriver
  public WebDriver getDriver() {
    return WebdriverInit.driver;
  }

  //find
  public WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  public List<WebElement> findAll(By locator) {
    return getDriver().findElements(locator);
  }

  //type
  public void type(By locator, String text) {
    WebElement element = find(locator);
    element.clear();
    element.sendKeys(text);
  }

  //click
  public void click(By locator) {
    find(locator).click();
  }

  //select
  public void selectByVisibleText(By locator, String text) {
    WebElement element = find(locator);
    Select select = new Select(element);
    select.selectByVisibleText(text);
  }

  //openURL
  public void openUrl(String url) {
    getDriver().get(url);
  }

  public void waitAbit(int timeInSecond) {
    try {
      Thread.sleep(timeInSecond * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public String getText(By locator) {
    return getDriver().findElement(locator).getText();
  }

}
