package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class NumberCheck {

	public static void main(String[] args) {
		int[] A = {1, 3, 5, 7, 9, 11, 13, 15};
		int sum = 30;
		int arr_size = A.length;
		findNumbers(A, arr_size, sum);
	}

	/**
	 * optimization number checking
	 */
	private static void findNumbers(int[] A, int arr_size, int sum) {
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1]
			// with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<>();
			int curr_sum = sum - A[i];
			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int) s.toArray()[s.size() - 1]) {
					System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
					return;
				}
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
	}

	private static void findNumbersO3() {
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
