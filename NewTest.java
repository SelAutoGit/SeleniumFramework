package edu.reporter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class NewTest {
  @Test
  public void TestOne() {
	  Assert.fail("test one failed");
  }
  @Test
  public void TestTwo(){
	  Assert.assertEquals(true, true);
	  
  }
  @BeforeMethod
  public void beforeMethod() {

  }

  @AfterMethod
  public void afterMethod() {
  }

}
