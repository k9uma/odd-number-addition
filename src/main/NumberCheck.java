package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class NumberCheck {

	public static void main(String[] args) {
		
        // Declare Array of Numbers to Be Checked
        Integer[] temp = {1, 3, 5, 7, 9, 11, 13, 15};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(temp));

        //This randomly picks any number in the arraylist as opposed to moving index by index
        Random rand = new Random(numbers.size());

        //TODO Create Algorithm
       
		/**
		 * So Algorithm works in a way that, 3 random numbers are picked from the arraylist and 
		 * are added together to see if the combination can give us 30.
		 * So the loop will continue until curr_result is equal to 30.
		 * PS watch out for the loop, it might make you pc hang. You will see why :)
		 */

		int curr_result = 0;

        while (true) {

            curr_result = numbers.get(rand.nextInt(numbers.size()))
                    + numbers.get(rand.nextInt(numbers.size()))
                    + numbers.get(rand.nextInt(numbers.size()));

            if (curr_result == 30) {
                break;
            }

            System.out.println("!The answer is: " + curr_result);

        }

	}

}
