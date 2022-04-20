import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility { 
	
	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row is 10 Each row in the file is separated by a new line Each element in the row is separated by a space Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array. Using a scanner of some sort. 
	 * @author thien
	 *
	 */
	
	public static double[][] readFile(java.io.File file) throws FileNotFoundException{  

		

		//Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row is 10 Each row in the file is separated by a new line Each element in the row is separated by a space Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array. Using a scanner of some sort. 

		Scanner something = new Scanner(file); 

		int row = 0;  

		int column = 0;  

		int[] columnPerRow = new int[10]; 

		double[][] maxArray = new double[10][10];

		while(something.hasNextLine() == true){  

			String currentLine = something.nextLine();
			
			Scanner otherScan = new Scanner(currentLine);

			while(otherScan.hasNextDouble()){

				maxArray[row][column] = otherScan.nextDouble();  

				column++;

			}

			columnPerRow[row] = column;

			column = 0;

			row++;

		}

		double[][] minimumArray = new double[row][];

			for(int i = 0; i < minimumArray.length; i++){

			minimumArray[i] = new double[columnPerRow[i]];  

			for(int j = 0; j < minimumArray[i].length; j++){

				minimumArray[i][j] = maxArray[i][j];

			}

		}
			return minimumArray;

		

		//Scanner something = new Scanner(System.in);
		//Scanner otherScan = new Scanner(currentLine);
		
		
	}
	//Method writeToFile
	/**Passes in a two-dimensional ragged array of doubles and a file, and writes the ragged array into the file. Each row is on a separate line and each double is separated by a space.   
*/
	 

	public static void writeToFile(double[][] data, File outputFile) throws IOException{ 

		//Working... 

		//Writes the ragged array of doubles into the file.  

  

		//Can’t remember at the moment how to write to files.  

  

		/* throws IOException { 
			//Remove one up top?
		} */

		String writeToFile = "";

		PrintWriter reader = new PrintWriter(new FileWriter(outputFile));
		
		FileWriter writer = new FileWriter(outputFile);

		for(int i = 0; i < data.length; i++){

			for(int J = 0; J < data[i].length; J++){  

				writeToFile += data[i][J];

				writeToFile += " ";

			}
			//Outer for loop
			writeToFile += "\n";

		}

		//Can’t remember proper method;

		//Made up method  

  

		writer.write(writeToFile);

		writer.close(); 

		//System.out.println("Is this running successfully?");

	}
	
	
		
		
		
		
		//Method getTotal
	
	/**pass in a two-dimensional ragged array of doubles and returns the total of the elements in the array.  
	**/

		public static double getTotal(double[][] data){  

			//Returns the total of all the elements of the two dimensional array  

			double total = 0;

			for(double[] arr : data){

				for(double e : arr){

					total += e;

				}

			}  

			return total;

		}
		
		//Method getAverage 
		/**pass in a two-dimensional ragged array of doubles and returns the average of the elements in the array (total/num of elements).
		**/
		public static double getAverage(double[][] data){

			//Returns the average of the elements in the two dimensional array.

			double total = 0;
			int counter = 0;

			for(double[] arr : data){

				for(double e : arr){

					total += e;
					
					counter++;

				}

			}

			return total/counter;

		}
		
		//Method getRowTotal
		/**
		 *  Passes in a two-dimensional ragged array of doubles and a row index and returns the total of that row. Row index 0 is the first row in the array.  
		 * @param data
		 * @param row
		 * @return
		 */
		public static double getRowTotal(double[][] data, int row){  

			//Returns the total of the selected row in the two dimensional array index 0 refers to the first row.

			double total = 0;

			for(int i = 0; i < data[row].length; i++){

				total += data[row][i];

			}

			return total;

		}
		
		/* Method getColumnTotal - */
		 /**
		 * Passes in a two-dimensional ragged array of doubles and a column index and returns the total of that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.
		 * @param data
		 * @param col
		 * @return
		 */
		public static double getColumnTotal(double[][] data, int col){  

			//Returns the total of the selected column in the two dimensional array index 0 refers to the first column.

			double total = 0;

					for(int I = 0; I < data.length; I++){

						try {
							total += data[I][col];
						}
						catch(ArrayIndexOutOfBoundsException exception) {
						//Do nothing - just continue.
						}

			}  

			return total;

		}
		
		
		
		/*Method getHighestInRow 
		 */
		/**Method passes in a two-dimensional ragged array of doubles and a row index and returns the largest element in that row. Row index 0 is the first row in the array. */ 

		public static double getHighestInRow(double[][] data, int row){  

			//Checks to see if row exists, nessecary?-
			
			if (data.length < row || row < 0) {
				return 0;
			}
			
			//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.

			double highest = -9999999;

			for(int I = 0; I < data[row].length; I++){  
				
				if(data[row][I] > highest){

					highest = data[row][I];

				}

			}
			return highest;

		}
		//Method getHighestInRowIndex
		/** Passes in a two-dimensional ragged array of doubles and a row index and returns the index of the largest element in that row. Row index 0 is the first row in the array. */   

		public static int getHighestInRowIndex(double[][] data, int row){  

			//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.

			double highest = -9999999;

			int highestIndex = -1;

			for(int I = 0; I < data[row].length; I++){

				if(data[row][I] > highest){
					
					//System.out.println(data[row][I]);
					
					highest = data[row][I];

					highestIndex = I;

				}

			}
			
			//System.out.print(highestIndex + "+");

			return highestIndex;  

		}
		// Method getLowestInRow - 
		/**A two-dimensional ragged array of doubles and a row index get parsed and the method returns the smallest element in that row. Row index 0 is the first row in the array.  */ 

		public static double getLowestInRow(double[][] data, int row){  

		//Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row. 

			double lowest = 9999999;

			int lowestIndex = -1;	  

			for(int I = 0; I < data[row].length; I++){

				if(data[row][I] < lowest){

					lowest = data[row][I];

					lowestIndex = I;

				}

			}

			return lowest;

		}
		
		/**
		 * Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
		 */
		
		public static int getLowestInRowIndex(double[][] data, int row){  

			
			double lowest = 9999999;
			double zero = 0;

			int lowestIndex = -1;
			int counter = 0;
			for(int I = 0; I < data[row].length; I++){
				
				
					//System.out.println(data[row][I] + " - " + I);
				if(data[row][I] < lowest){

					lowest = data[row][I];

					lowestIndex = I;
					

			}
			}
			//System.out.println("+++++");
			return lowestIndex - counter;

		}  
		
		/**A two-dimensional ragged array of doubles and a row index gets parsed and the method returns the index of the smallest element in that row. (except for zero) Row index 0 is the first row in the array. **/ 

		public static int getLowestInRowIndexNonZero(double[][] data, int row){  

			//Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.

			double lowest = 9999999;
			double zero = 0;

			int lowestIndex = -1;
			int counter = 0;
			for(int I = 0; I < data[row].length; I++){
				
				
					//System.out.println(data[row][I] + " - " + I);
				if(data[row][I] < lowest && data[row][I] > 0){

					lowest = data[row][I];

					lowestIndex = I;
					

			}
			}
			//System.out.println("+++++");
			return lowestIndex - counter;

		} 
		// Method getHighestInColumn
		/**Passes in a two-dimensional ragged array of doubles and a column index and returns the largest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.  **/ 

		public static double getHighestInColumn(double[][] data, int col){  

			//Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column.

			double biggest = -99999999;

			for(int I = 0; I < data.length; I++){
				
				try {
					if(data[I][col] > biggest){

						biggest = data[I][col];

					}
				}
				catch(ArrayIndexOutOfBoundsException exception) {
				//Do nothing - just continue.
				}

			}

			return biggest;

		}
		/**
		 * This method returns the largest element (except for zero) of the selected column in the two dimensional array index 0 refers to the first column.
		 * @param data
		 * @param col
		 * @return
		 */
		public static double getHighestInColumnNonZero(double[][] data, int col){  

			
			double biggest = 0; //Changed, what about a case where the negative numbers are the biggest?

			for(int I = 0; I < data.length; I++){
				
				try {
					if(data[I][col] > biggest){

						biggest = data[I][col];

					}
				}
				catch(ArrayIndexOutOfBoundsException exception) {
				//Do nothing - just continue.
				}

			}

			return biggest;

		}
		// Method getHighestInColumnIndex
		/**This method passes in a two-dimensional ragged array of doubles and a column index and returns the index of the largest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method. **/ 

		public static int getHighestInColumnIndex(double[][] data, int col){  

			//Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 

			double biggest = -99999999; 

			int biggestIndex = -1;

			for(int I = 0; I < data.length; I++){
				
				try {
					if(data[I][col] > biggest){

						biggest = data[I][col];

						biggestIndex = I;

					}
				}
				catch(ArrayIndexOutOfBoundsException exception) {
				//Do nothing - just continue.
				}

			}

			return biggestIndex;

		}
		/**
		 * Returns index of the largest element (except for zero) of the selected column in the two dimensional array index 0 refers to the first column. 
		 * @param data
		 * @param col
		 * @return
		 */
		public static int getHighestInColumnIndexNonZero(double[][] data, int col){  

			
			double biggest = 0; //Changed, what about a case where the negative numbers are the biggest?

			int biggestIndex = -1;

			for(int I = 0; I < data.length; I++){
				
				try {
					if(data[I][col] > biggest){

						biggest = data[I][col];

						biggestIndex = I;

					}
				}
				catch(ArrayIndexOutOfBoundsException exception) {
				//Do nothing - just continue.
				}

			}

			return biggestIndex;

		}
		/**
		 * This method returns the smallest element (except for zero) of the selected column in the two dimensional array index 0 refers to the first column. 
		 * @param data
		 * @param col
		 * @return
		 */
		public static double getLowestInColumnNonZero(double[][] data, int col){  

			
			double lowest = 999999;
			double zero = 0; 

			int lowestIndex = -1; 

			for(int I = 0; I < data.length; I++){ 
				
				try {
					if(data[I][col] < lowest && data[I][col] > 0){ 

						lowest = data[I][col]; 

						lowestIndex = I; 

					} 
				}
				catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
				}

			} 

			return lowest; 

		}  
		// Method getLowestInColumn
		/**This method passes in a two-dimensional ragged array of doubles and a column index and returns the smallest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method. **/ 

		public static double getLowestInColumn(double[][] data, int col){  

			//Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 

			double lowest = 999999;
			double zero = 0; 

			int lowestIndex = -1; 

			for(int I = 0; I < data.length; I++){ 
				
				try {
					if(data[I][col] < lowest){ 

						lowest = data[I][col]; 

						lowestIndex = I; 

					} 
				}
				catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
				}

			} 

			return lowest; 

		}  
		// Method getLowestInColumnIndex
		/**This method passes in a two-dimensional ragged array of doubles and a column index and returns the index of the smallest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method. **/ 

		public static int getLowestInColumnIndex(double[][] data, int col){  

			//Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column.  

			double lowest = 999999;

			int lowestIndex = -1;

			for(int I = 0; I < data.length; I++){
				
				try {
					
					if(data[I][col] < lowest){

						lowest = data[I][col];

						lowestIndex = I;

					}
					
				}
				catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
				}

				

			}

			return lowestIndex;

		}  
		
		/** This method passes in a two-dimensional ragged array of doubles and returns the largest element in the array. **/

		public static double getHighestInArray(double[][] data){  

			//Returns the largest element in the two dimensional array	  

			double largest = -99999;

			for(int I = 0; I < data.length; I++){

				for(int j = 0; j < data[I].length; j++){

					if(data[I][j] > largest){

						largest = data[I][j];

					}

				}

			} 

			return largest;

		}  
		
		/** This method passes in a two-dimensional ragged array of doubles and returns the smallest element in the array. **/

		public static double getLowestInArray(double[][] data){  

			//Returns the smallest element in the two dimensional array

			double smallest = 99999;

			for(int I = 0; I < data.length; I++){

				for(int j = 0; j < data[I].length;  j++){

					if(data[I][j] < smallest){

						smallest = data[I][j];

					}

				}

			}

			return smallest;

		}
		/**
		 * This method returns the index of the smallest element (except for zero) of the selected column in the two dimensional array index 0 refers to the first column.  
		 * @param data
		 * @param col
		 * @return
		 */
		public static int getLowestInColumnIndexNonZero(double[][] data, int col) {
			
			double lowest = 999999;

			int lowestIndex = -1;

			for(int I = 0; I < data.length; I++){
				
				try {
					
					if(data[I][col] < lowest && data[I][col] > 0){

						lowest = data[I][col];

						lowestIndex = I;

					}
					
				}
				catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
				}

				

			}

			return lowestIndex;
		}  
		
}