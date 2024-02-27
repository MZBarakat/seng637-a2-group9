package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

/**
 * Tests for the Range class.
 */
public class RangeTest {
	
	/* An example range used in most test methods*/
    private static Range exampleRange1;
    
    /* The delta of error */
    private static final double DEFAULT_DELTA = 0.000000001d;
    
    /* The default timeout of test in milliseconds */
    private static final int DEFAULT_TIMEOUT = 2000;
    
    /**
     *	Sets up once prior to testing
     */
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    	//this range is the common test range for most tests
    	exampleRange1 = new Range(3.0, 7.0);
    }

    /**
     *	Sets up before each test method
     */
    @Before
    public void setUp() throws Exception { 
    
    }
    
    /**
     *	ID: SECT1
     *  This test covers a NOM value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfFiveShouldBeFive() {
    	//Verify expectations
        assertEquals("The constrain value 5 in range 3 and 7 should be 5",
        5.0, exampleRange1.constrain(5.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT2
     *  This test covers a E1 & LB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfThreeShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value 3 in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(3.0), DEFAULT_DELTA);
    }

    /**
     *	ID: SECT3
     *  This test covers a E1 & UB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfSevenShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value 7 in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(7.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT4
     *  This test covers a E1 & BLB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfTwoShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value 2 in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(2.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT5
     *  This test covers a E1 & AUB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfEightShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value 8 in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(8.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT6
     *  This test covers a E2 & BLB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleMinValueShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value Double.MIN_VALUE in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(Double.MIN_VALUE), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT7
     *  This test covers a E3 & AUB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleMaxValueShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value Double.MAX_VALUE in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(Double.MAX_VALUE), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT8
     *  This test covers a U1 value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleNanShouldBeDoubleNan() {
    	
    	//Setup data
    	double result = exampleRange1.constrain(Double.NaN);
    	
    	//Verify expectations
        assertTrue("The constrain value Double.NaN in range 3 and 7 should be NaN",
        Double.isNaN(result));
    }
    
    /**
     *	ID: SECT9
     *  This test covers a E1 & Nom value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfFiveShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(5.0);
    	
    	//Verify expectations
        assertTrue("Contains value 5 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT10
     *  This test covers a E1 & LB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfThreeShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(3.0);
    	
    	//Verify expectations
        assertTrue("Contains value 3 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT11
     *  This test covers a E1 & UB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfSevenShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(7.0);
    	
    	//Verify expectations
        assertTrue("Contains value 3 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT12
     *  This test covers a E2 & BLB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfTwoShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(2.0);
    	
    	//Verify expectations
        assertFalse("Contains value 2 in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT13
     *  This test covers a E2 & AUB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfEightShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(8.0);
    	
    	//Verify expectations
        assertFalse("Contains value 8 in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT14
     *  This test covers a E2 & BLB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleMinValueShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.MIN_VALUE);
    	
    	//Verify expectations
        assertFalse("Contains value Double.MIN_VALUE in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT15
     *  This test covers a E2 & AUB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleMaxValueShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.MAX_VALUE);
    	
    	//Verify expectations
        assertFalse("Contains value Double.MAX_VALUE in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT16
     *  This test covers a U1 value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleNanShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.NaN);
    	
    	//Verify expectations
        assertFalse("Contains value Double.Nan in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT17
     *  This test covers a E1 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsSameRangeShouldBeTrue() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,7);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertTrue("Range(3,7) and Range(3,7) should be true",
        result);
    }
    
    /**
     *	ID: SECT18
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentUpperValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,10);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(3,10) should be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT19
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentLowerValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(4,7);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(4,7) should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT20
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentLowerAndUpperValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(1,10);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(1,10) should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT21
     *  This test covers a E3 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentObjectShouldBeFalse() {
    	
    	//Setup data
    	double another = 1.0;
    	boolean result = exampleRange1.equals(another);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and a double should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT22
     *  This test covers a E3 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsNullRangeShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.equals(null);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and null should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT23
     *  This test covers a E1 & Positive range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeFive() {
    	
    	//Verify expectations
        assertEquals("The central value in range 3 and 7 should be 5",
        5.0, exampleRange1.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT24
     *  This test covers a E1 & Negative range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeNegativeFive() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,-3);
    	
    	//Verify expectations
        assertEquals("The central value in range -7 and -3 should be -5",
        -5.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT25
     *  This test covers a E1 & Mixed range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeNegativeTwo() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,3);
    	
    	//Verify expectations
        assertEquals("The central value in range -7 and 3 should be -2",
        -2.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT26
     *  This test covers a E1 & Same range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeThree() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,3);
    	
    	//Verify expectations
        assertEquals("The central value in range 3 and 3 should be 3",
        3.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT27
     *  This test covers a E1 & Extreme range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeZero() {
    	
    	//Setup data
    	Range anotherRange = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
    	
    	//Verify expectations
        assertEquals("The central value in range -Double.MAX_VALUE and Double.MAX_VALUE should be 0",
        0.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT28
     *  This test covers a E1 & Positive range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeFour() {
    	
    	//Verify expectations
        assertEquals("The length in range 3 and 7 should be 4",
        4.0, exampleRange1.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT29
     *  This test covers a E1 & Negative range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeThree() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,-4);
    	
    	//Verify expectations
        assertEquals("The length in range -7 and -4 should be 3",
        3.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT30
     *  This test covers a E1 & Mixed range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeTen() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,3);
    	
    	//Verify expectations
        assertEquals("The length in range -7 and 3 should be 10",
        10.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT31
     *  This test covers a E1 & Same range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeZero() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,3);
    	
    	//Verify expectations
        assertEquals("The length in range 3 and 3 should be 0",
        0.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT32
     *  This test covers a E1 & Extreme range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeDoubleMaxValue() {
    	
    	//Setup data
    	Range anotherRange = new Range(0,Double.MAX_VALUE);
    	
    	//Verify expectations
        assertEquals("The length in range 0 and Double.MAX_VALUE should be Double.MAX_VALUE",
        Double.MAX_VALUE, anotherRange.getLength(), DEFAULT_DELTA);
    }
   
    /**
     *	Tear down after each test method
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     *	Tear down once after all tests
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	exampleRange1 = null;
    }
}