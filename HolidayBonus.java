
public class HolidayBonus {
	
	/**
	 * 
	 * Calculates the holiday bonus for each store.
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */

	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other){ 

		/*

		int unjagged = data.length;  

		int longestRow = 0; 



		for(int I = 0; I < unjagged; I++){ 

			if(longestRow < data[I].length){ 

				longestRow = data[I].length; 

			} 

		} 





		double[] answer = new double[unjagged]; 

		double[][] square = new double[unjagged][longestRow]; */

		/*

		for(int I = 0; I < square.length; I++){ 



			for(int j = 0; j < square[I].length; j++){ 

				square[I][j] = (Double) null; 

			} 



		} */
		
		//Do not believe code is needed.

		/*

		for(int I = 0; I < data.length; I++){ 

			for(int j = 0; j < data[I].length; j++){ 

				if(data[I][j] <= 0){ 

					//Do nothing 

				} 

				else{ 

					square[I][j] = data[I][j]; 

				} 

			} 

		} 

		double highest = 0;
		*/
		/*
		for(int I = 0; I < square.length; I++){

			for(int j = 0; j < longestRow; j++){

				highest = TwoDimRaggedArrayUtility.getHighestInColumn(square, j);

				double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(square, j); 

				//Double[][] square2 = square;

				Double squareCompare = square[I][j];
				Double highestCompare = highest;
				Double lowestCompare = lowest;

				if((squareCompare.equals(highest) || squareCompare.equals(lowest) || squareCompare == (null)) == false){ 

					answer[I] += other; 

				} 

				if(highestCompare.equals(lowest)){ answer[TwoDimRaggedArrayUtility.getHighestInColumnIndex(square, j)] += high; 

				} 

				else{answer[TwoDimRaggedArrayUtility.getHighestInColumnIndex(square, j)] += high; answer[TwoDimRaggedArrayUtility.getLowestInColumnIndex(square, j)] += low; 



				} 

			} 



		} 

		return answer; 
		*/
		
		int longestRow = 0;

		for(int I = 0; I < data.length; I++){ 

			if(longestRow < data[I].length){ 

				longestRow = data[I].length; 

			} 

		} 
		
		double[] answer = new double[data.length];
		
		
			
			double highest = 0;
			double lowest = 0;
			
			for(int j = 0; j < longestRow; j++) {
				
				highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);

				lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
				
				Double highestCompare = highest;
				Double lowestCompare = lowest;
				
				int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				
				if(highestCompare.equals(lowestCompare)) {
					
					if(highest > 0) {
						answer[highIndex] += high;
					}
				}
				else {
					if(highest > 0) {
						answer[highIndex] += high;
					}
					if(lowest > 0) {
						
						answer[lowIndex] += low;
						
						
						
					}
					
				}
				
				for(int i = 0; i < data.length; i++) {
					
					try {
						double compare = data[i][j];
						if(compare != highest && compare != lowest && compare > 0) {
							answer[i] += other;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
					}	
					
				} //End of inner for loop.
				
			}
			/*
			System.out.println("+++++++++++");
			for(int i =0; i < answer.length; i++) {
				System.out.println(answer[i]);
			}
			System.out.println("-------------");
			*/
			
			//answer[answer.length -1] += low;
			
			return answer;
	}
	/**
	 * Calculates the holiday bonus for each store, overloaded method for testing..
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @param test
	 * @return
	 */
	//Overloaded method, test method-
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other, boolean test){ 

		int longestRow = 0;

		for(int I = 0; I < data.length; I++){ 

			if(longestRow < data[I].length){ 

				longestRow = data[I].length; 

			} 

		} 
		
		double[] answer = new double[data.length];
		
		
			
			double highest = 0;
			double lowest = 0;
			
			for(int j = 0; j < longestRow; j++) {
				
				highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);

				lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
				
				Double highestCompare = highest;
				Double lowestCompare = lowest;
				
				int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				
				if(highestCompare.equals(lowestCompare)) {
					
					if(highest > 0) {
						answer[highIndex] += high;
					}
				}
				else {
					if(highest > 0) {
						answer[highIndex] += high;
					}
					if(lowest > 0) {
						System.out.println(low + "-+-+-+-");
						answer[lowIndex] += low;
					}
					
				}
				
				for(int i = 0; i < data.length; i++) {
					
					try {
						double compare = data[i][j];
						if(compare != highest && compare != lowest && compare > 0) {
							answer[i] += other;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException exception) {
					//Do nothing - just continue.
					}	
					
				} //End of inner for loop.
				
			}
			
			if(test == true) {
			System.out.println("+++++++++++");
			for(int i =0; i < answer.length; i++) {
				System.out.println(answer[i]);
			}
			System.out.println("-------------");
			}
			
			//answer[answer.length -1] += low;
			
			return answer;
	}
	/**
	 * 
	 *  Calculates the total holiday bonuses
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */

	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other){ 
		//Calculates the total holiday bonuses 



		double[] oneDArray = calculateHolidayBonus(data, high, low, other); 

		double total = 0;

		for(int I = 0; I < oneDArray.length; I++){ 

			total += oneDArray[I]; 

		} 

		return total; 

	} 

}
