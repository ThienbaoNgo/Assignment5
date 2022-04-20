

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	//private double[][] dataSetSTUDENT = null;
	
	private File inputFile, outputFile;
	
	private double[][] dataSetSTUDENT = {{-3,-2.4, 5, 5.2},
			   							 { -2.4, 6.8, -5.9},
			   							 { 4.3, 6.6},
			   							 { -3.9, 7.7, 2.6}};
	private double[][] dataSetSTUDENT2 = {{1,2,1},
										  {2,1,2},
										  {1,2,1},
										  {2,1,2} };

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		
		assertEquals(18,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2),.001);
		assertEquals(20.6,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		
		//fail("Student testGetTotal not implemented");	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		
		assertEquals(1.5,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
		assertEquals(1.716,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		
		//fail("Student testGetAverage not implemented");	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		
		assertEquals(4,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2, 0),.001);
		assertEquals(4.8,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0),.001);
		
		//fail("Student testGetRowTotal not implemented");	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		
		assertEquals(6,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2, 0),.001);
		assertEquals(-5,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0),.001);
		
		//fail("Student testGetColumnTotal not implemented");	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2),.001);
		assertEquals(7.7,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		
		//fail("Student testGetHighestInArray not implemented");	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		
		double[][] array=null;
		
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		
		
		assertEquals(-3, array[0][0],.001);
		assertEquals(-2.4, array[0][1],.001);
		assertEquals(5, array[0][2],.001);
		assertEquals(5.2, array[0][3],.001);
		
		assertEquals(-2.4, array[1][0],.001);
		assertEquals(6.8, array[1][1],.001);
		assertEquals(-5.9, array[1][2],.001);
		
		assertEquals(4.3, array[2][0],.001);
		assertEquals(6.6, array[2][1],.001);
		
		assertEquals(-3.9, array[3][0],.001);
		assertEquals(7.7, array[3][1],.001);
		assertEquals(2.6, array[3][2],.001);
		
		
		//fail("Student testWriteToFile not implemented");	
	}

}