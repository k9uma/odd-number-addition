package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberCheck {

	public static void main(String[] args) {
		// Declare Array of Numbers to Be Checked

		Integer[] temp = {1, 3, 5, 7, 9, 11, 13, 15};
		
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(temp));
		
		//Reverse the list
		Collections.sort(numbers, Collections.reverseOrder());
		
		//TODO Create Algorithm
		
		int $ideal_result = 30;
		
		int $curr_result = 0;
		
		for (int i = 0; i < numbers.size(); i++)
		{
			for (int j = i + 1; j < numbers.size(); j++) {
				
				for (int k = i + 1; k < numbers.size(); k++) {
					$curr_result = numbers.get(i) + numbers.get(j) + numbers.get(k);
					
					System.out.println("Result:" + $curr_result);
					
					if($curr_result == $ideal_result) {
						
						break;
						
					}
					
				}
				
			}
	
			//System.out.println(numbers.get(i));
		}

		//System.out.println("Hello World");

	}

}
