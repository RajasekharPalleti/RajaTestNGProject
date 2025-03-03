package org.example;

import org.testng.annotations.*;

public class AnnotationsTest {

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("Executing Before Suite - Setup before the entire suite");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("Executing After Suite - Cleanup after the entire suite");
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("Executing Before Test - Runs before <test> in testng.xml");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("Executing After Test - Runs after <test> in testng.xml");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("Executing Before Class - Runs before this class");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("Executing After Class - Runs after this class");
  }

  @BeforeMethod
  public void beforeMethod() {
    System.out.println("Executing Before Method - Runs before each test method");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("Executing After Method - Runs after each test method");
  }

  @BeforeGroups("smoke")
  public void beforeSmokeGroup() {
    System.out.println("Executing Before Smoke Group - Setup before smoke tests");
  }

  @AfterGroups("smoke")
  public void afterSmokeGroup() {
    System.out.println("Executing After Smoke Group - Cleanup after smoke tests");
  }

  @BeforeGroups("regression")
  public void beforeRegressionGroup() {
    System.out.println("Executing Before Regression Group - Setup before regression tests");
  }

  @AfterGroups("regression")
  public void afterRegressionGroup() {
    System.out.println("Executing After Regression Group - Cleanup after regression tests");
  }

  @Test(groups = {"smoke"})
  public void test1() {
    System.out.println("Executing Smoke Test 1");
  }

  @Test(groups = {"smoke"})
  public void test2() {
    System.out.println("Executing Smoke Test 2");
  }

  @Test(groups = {"regression"})
  public void test3() {
    System.out.println("Executing Regression Test 1");
  }

  @Test(groups = {"regression", "sanity"})
  public void test4() {
    System.out.println("Executing Regression and Sanity Test");
  }
}

// Output:
/*Executing Before Suite - Setup before the entire suite
Executing Before Test - Runs before <test> in testng.xml
Executing Before Class - Runs before this class
Executing Before Smoke Group - Setup before smoke tests
Executing Before Method - Runs before each test method
Executing Smoke Test 1
Executing After Method - Runs after each test method
Executing Before Method - Runs before each test method
Executing Smoke Test 2
Executing After Method - Runs after each test method
Executing After Smoke Group - Cleanup after smoke tests
Executing Before Regression Group - Setup before regression tests
Executing Before Method - Runs before each test method
Executing Regression Test 1
Executing After Method - Runs after each test method
Executing Before Method - Runs before each test method
Executing Regression and Sanity Test
Executing After Method - Runs after each test method
Executing After Regression Group - Cleanup after regression tests
Executing After Class - Runs after this class
Executing After Test - Runs after <test> in testng.xml
Executing After Suite - Cleanup after the entire suite

===============================================
Test Suite
Total tests run: 4, Passes: 4, Failures: 0, Skips: 0
===============================================


Process finished with exit code 0
*/
