package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberCheckDavid {
    public static void main(String[] args) {
        int eureka = 30;
        boolean eurekaFound = false;

        Integer[] temp = {1, 3, 5, 7, 9, 11, 13, 15};

        List<Integer> numbers = Arrays.asList(temp);

        // Label the for loop so we can break from the inner loop
        outerLoop:
        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer firstNumber = numbers.get(i);
            List<Integer> options = numbers.stream()
                                           .skip(i + 1)
                                           .collect(Collectors.toList());

            // Create the combination of possible options based on the current index and the remaining numbers
            List<List<Integer>> possibleCombinations = NumberCheckDavid.createArrayCombinations(firstNumber, options);

            for (List<Integer> currentCombination : possibleCombinations) {
                int sumOfCombination = currentCombination.stream()
                                                         .reduce(0, Integer::sum);
                if (sumOfCombination == eureka) {
                    eurekaFound = true;
                    System.out.println("Winning combination = " + currentCombination);
                    break outerLoop;
                }
            }
        }

        // Print a message if the combination does not sum to the magic number
        if (!eurekaFound) {
            String message = String.format("None of the combinations add up to %d", eureka);
            System.out.println(message);
        }
    }

    /**
     * Create all possible combinations given an initial integer and a list of integers
     * @param firstNumber An integer
     * @param options A list of integers
     * @return  A two dimensional list of possible combinations
     */
    private static List<List<Integer>> createArrayCombinations(Integer firstNumber, List<Integer> options) {
        List<List<Integer>> listOfCombinations = new ArrayList<>();

        Integer currentIndex = 0;
        Integer optionsSize = options.size();

        while (currentIndex < optionsSize) {
            Integer secondNumber = options.get(currentIndex);

            int optionsToSkip = currentIndex + 1;
            List<Integer> combinationOptions = options.stream()
                                                      .skip(optionsToSkip)
                                                      .collect(Collectors.toList());

            combinationOptions.forEach(thirdNumber -> {
                List<Integer> combination = new ArrayList<>();
                combination.add(firstNumber);
                combination.add(secondNumber);
                combination.add(thirdNumber);

                listOfCombinations.add(combination);
            });

            currentIndex++;
        }

        return listOfCombinations;
    }
}