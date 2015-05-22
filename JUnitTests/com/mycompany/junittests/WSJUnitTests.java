package com.mycompany.junittests;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import com.mycompany.ws.*;

/**
 *
 *
 * @author rbrown6455@hotmail.com (Robert Brown)
 */

public class WSJUnitTests {

      FibonacciUtil fibUtil = null;

  public WSJUnitTests () {
      super();
  }

  @Before
  public void createValidFibStrings() {
 
      fibUtil = new FibonacciUtil();
  }


  @Test
  public void thisShouldTestThatFibonacciUtilityReturnsCorrectString() {


      // Fibonacci(0) should return 0
      StringBuffer fibString = new StringBuffer();
      fibUtil.fibS(0, fibString);
      assertThat("Expext 0 ", fibString.toString(), containsString("0 "));
      fibString = null;

      // Fibonacci(1) should return 0
      fibString = new StringBuffer();
      fibUtil.fibS(1, fibString);
      assertThat("Expect 0 ", fibString.toString(), containsString("0 "));
      fibString = null;
      
      // Fibonacci(2) should return 0 1
      fibString = new StringBuffer();
      fibUtil.fibS(2, fibString);
      assertThat("Expect 0 1 ", fibString.toString(), containsString("0 1 "));
      fibString = null;

      // Fibonacci(3) should return 0 1 1
      fibString = new StringBuffer();
      fibUtil.fibS(3, fibString);
      assertThat("Expect 0 1 1 ", fibString.toString(), containsString("0 1 1 "));
      fibString = null;


      // Fibonacci(7) should return 0 1 1 2 3 5 8
      fibString = new StringBuffer();
      fibUtil.fibS(7, fibString);
      assertThat("Expect 0 1 1 2 3 5 8 ", fibString.toString(), containsString("0 1 1 2 3 5 8 "));
      fibString = null;

  }

  /* 
   *  The following test generates the expected StackOverflowError, but JUnit
   *  is reporting is as a Failure, instead of reporting it as Passed.
   *  So, the test for StackOverflow is done using the next 
   *  testThatFibUtilGeneratesStackOverFlowWhenInputIsTooBig() method
   *  below.
  @Test(expected=StackOverflowError.class)
  public void testThatFibUtilGeneratesStackOverFlowWhenInputIsTooBig() {


      StringBuffer fibString = new StringBuffer();
      fibUtil.fibS(50000, fibString);
      fibString = null;

  }

  */

  @Test()
  public void testThatFibUtilGeneratesStackOverFlowWhenInputIsTooBig() {

      StringBuffer fibString = new StringBuffer();
      assertEquals("Should be -1", -1, fibUtil.fibS(50000, fibString));
      fibString = null;
  }

  @Test()
  public void testThatFibUtilDoesNotGeneratesStackOverFlowWhenInputIsNormal() {

      StringBuffer fibString = new StringBuffer();
      assertEquals("Should be 1", 1, fibUtil.fibS(20000, fibString));
      fibString = null;
  }

  public static void main(String args[]) {


     org.junit.runner.JUnitCore.main("com.mycompany.junittests.WSJUnitTests");

   }

}
