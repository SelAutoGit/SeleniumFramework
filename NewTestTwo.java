package edu.reporter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTestTwo {
  @Test
  public void TestThree() {
	  INGReporter reporter = new INGReporter();
	  reporter.printInitHTML(reporter.setDefaultPrinter());
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
