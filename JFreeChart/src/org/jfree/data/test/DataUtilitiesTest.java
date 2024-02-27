package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests for the DataUtilities class.
 */
public class DataUtilitiesTest {
	
    /* The delta of error */
    private static final double DEFAULT_DELTA = 0.000000001d;
    
    /* The default timeout of test in milliseconds */
    private static final int DEFAULT_TIMEOUT = 2000;
    
    /**
     *	Sets up once prior to testing
     */
    @BeforeClass public static void setUpBeforeClass() throws Exception {
      
    }
 
    /**
     *	Sets up before each test method
     */
    @Before
    public void setUp() throws Exception { 
    	
    }
    
    /**
     *	ID: SECT33
     *  This test covers a E1 & E2 & LB for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeTweleve() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 0);
            will(returnValue(1));
            oneOf(values1).getValue(1, 0);
            will(returnValue(4));
            oneOf(values1).getValue(2, 0);
            will(returnValue(7));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 0);

        // verify
        assertEquals("Column total for column 0 (1,4,7) should be 12",
        12.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT34
     *  This test covers a E1 & E2 & UB for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeEighteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 2);
            will(returnValue(3));
            oneOf(values1).getValue(1, 2);
            will(returnValue(6));
            oneOf(values1).getValue(2, 2);
            will(returnValue(9));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 2);

        // verify
        assertEquals("Column total for column 2 (3,6,9) should be 18",
        18.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT35
     *  This test covers a E1 & E2 & NOM for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeFifteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 1);
            will(returnValue(2));
            oneOf(values1).getValue(1, 1);
            will(returnValue(5));
            oneOf(values1).getValue(2, 1);
            will(returnValue(8));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 1);

        // verify
        assertEquals("Column total for column 1 (2,5,8) should be 15",
        15.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT36
     *  This test covers a U1 for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeZeroForColumnNegativeOne() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, -1);
            will(returnValue(null));
            oneOf(values1).getValue(1, -1);
            will(returnValue(null));
            oneOf(values1).getValue(2, -1);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, -1);

        // verify
        assertEquals("Column total for column -1 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT37
     *  This test covers a U2 for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeZeroForColumnThree() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 3);
            will(returnValue(null));
            oneOf(values1).getValue(1, 3);
            will(returnValue(null));
            oneOf(values1).getValue(2, 3);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 3);

        // verify
        assertEquals("Column total for column 3 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT38
     *  This test covers a U3 for input variable column in method and an invalid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void calculateColumnTotalShouldRaiseInvalidParameterException() {
        
        // exercise
        try {
        	//should throw error
			DataUtilities.calculateColumnTotal(null, 0);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}

    }
    
    
    /**
     *	ID: SECT39
     *  This test covers a E1 & E2 & LB for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeSix() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 0);
            will(returnValue(1));
            oneOf(values1).getValue(0, 1);
            will(returnValue(2));
            oneOf(values1).getValue(0, 2);
            will(returnValue(3));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 0);

        // verify
        assertEquals("Column total for row 0 (1,2,3) should be 6",
        6.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT40
     *  This test covers a E1 & E2 & UB for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeTwentyFour() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(2, 0);
            will(returnValue(7));
            oneOf(values1).getValue(2, 1);
            will(returnValue(8));
            oneOf(values1).getValue(2, 2);
            will(returnValue(9));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 2);

        // verify
        assertEquals("Column total for row 2 (7,8,9) should be 24",
        24.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT41
     *  This test covers a E1 & E2 & NOM for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeFifteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(1, 0);
            will(returnValue(4));
            oneOf(values1).getValue(1, 1);
            will(returnValue(5));
            oneOf(values1).getValue(1, 2);
            will(returnValue(6));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 1);

        // verify
        assertEquals("Column total for row 1 (4,5,6) should be 15",
        15.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT42
     *  This test covers a U1 for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeZeroForRowNegativeOne() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(-1, 0);
            will(returnValue(null));
            oneOf(values1).getValue(-1, 1);
            will(returnValue(null));
            oneOf(values1).getValue(-1, 2);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, -1);

        // verify
        assertEquals("Column total for row -1 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT43
     *  This test covers a U2 for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeZeroForRowThree() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(3, 0);
            will(returnValue(null));
            oneOf(values1).getValue(3, 1);
            will(returnValue(null));
            oneOf(values1).getValue(3, 2);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 3);

        // verify
        assertEquals("Column total for row 3 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT44
     *  This test covers a U3 for input variable row in method and a invalid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void calculateRowTotalShouldRaiseInvalidParameterException() {
        
        try {
        	//should throw error
			DataUtilities.calculateRowTotal(null, 0);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}

    }
    
    /**
     *	ID: SECT45
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveLengthThree() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {1,2,3};
    	 
    	// exercise 
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[3] is 3",
        3.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT46
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveValueTwoInFirstIndex() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {1,2,3};
    	 
    	// exercise 
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from exampleArray[1] is 2",
        2.0, result[1].doubleValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT47
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveLengthZero() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {};
    	 
    	// exercise
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT48
     *  This test covers U1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void createNumberArrayShouldRaiseInvalidParameterException() {
    	 
    	 
         try {
        	// should throw error
        	DataUtilities.createNumberArray(null);
        	
        	//if it reaches here fail as it didnt throw error
 			fail( "Should have thrown InvalidParameterException" );
 		} catch (Exception e) {
 			//e.printStackTrace();
 		}

    }
    
    /**
     *	ID: SECT49
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthTwoRows() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	 
    	// exercise
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[2][3] is 2",
        2.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT50
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthThreeColumns() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	
    	// exercise
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[2][3] is 3",
        3.0, result[0].length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT51
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveValueFive() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	 
    	// exercise  
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The value of Number[] from exampleArray[1][1] is 5",
        5.0, result[1][1].doubleValue(), DEFAULT_DELTA);
    }
	
    /**
     *	ID: SECT52
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthZeroRows() {
    	
    	//Setup data
    	double[][] exampleArray = new double[][] {};

    	// exercise 
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[][] from double[0][0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT53
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthZeroColumns() {
    	
    	//Setup data
    	double[][] exampleArray = new double[][] {};

    	// exercise  
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[][] from double[0][0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT54
     *  This test covers U1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void createNumberArray2DShouldRaiseInvalidParameterException() {
    	 
         try {
        	// should throw error
        	DataUtilities.createNumberArray2D(null);
        	
        	//if it reaches here fail as it didnt throw error
 			fail( "Should have thrown InvalidParameterException" );
 		} catch (Exception e) {
 			//e.printStackTrace();
 		}

    }
    
    /**
     *	ID: SECT55
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveThreeKeys() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have three keys",
        3, result.getKeys().size(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT56
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesSameLengthShouldBeTrue() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);
        Boolean checkLength = result.getItemCount() == 3; 
     
        // verify
        assertTrue("The item count for result should have three counts",
        		checkLength);
    }
    
    /**
     *	ID: SECT57
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveLastValueOne() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have three keys",
        1.0, result.getValue(2).doubleValue(), DEFAULT_DELTA);
    }
    
	
    /**
     *	ID: SECT58
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveZeroKeys() {
    	
    	// setup & mock
        /*
      {
	   }
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
            will(returnValue(0));
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have zero keys",
        0.0, result.getKeys().size(), DEFAULT_DELTA);
    }
	
    /**
     *	ID: SECT59
     *  This test covers a U1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldRaiseInvalidParameterException() {
    	
    	// setup & mock
        /*
      {
	   }
        */
        
        try {
        	
        	// should throw error
			DataUtilities.getCumulativePercentages(null);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}
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
    	
    }
	
}
