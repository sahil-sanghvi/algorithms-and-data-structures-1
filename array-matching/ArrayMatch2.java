import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ArrayMatch2 {
    public static void main(String[] args) {

        // Check if filename argument is provided
        if (args.length > 0) {
            String inputFileName = args[0]; // File name to be read

            try {
                // Open the file for reading
                FileInputStream fileStream = new FileInputStream(inputFileName);
                Scanner fileScanner = new Scanner(fileStream);

                // Read the number of elements for the arrays
                int arraySize = fileScanner.nextInt();
                int[] arrayOne = new int[arraySize];
                int[] arrayTwo = new int[arraySize];

                // Populate the first array with values from the file
                for (int i = 0; i < arraySize; i++) {
                    arrayOne[i] = fileScanner.nextInt();
                }

                // Populate the second array with values from the file
                for (int j = 0; j < arraySize; j++) {
                    arrayTwo[j] = fileScanner.nextInt();
                }

                // Check if the two arrays match based on custom criteria
                if (arraysMatch(arrayOne, arrayTwo)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

                // Close the scanner after reading is complete
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found - " + inputFileName);
            }
        } else {
            System.out.println("Error: Please provide a filename as a command-line argument.");
        }
    }

    // Method to initiate the recursive matching of two arrays
    public static boolean arraysMatch(int[] firstArray, int[] secondArray) {
        return recursiveMatchCheck(firstArray, secondArray, 0, firstArray.length);
    }

    // Recursive method to check if two subarrays match within a specific range
    private static boolean recursiveMatchCheck(int[] firstArray, int[] secondArray, int startIndex, int length) {

        // Base case: when the length of the segment to check is 1
        if (length == 1) {
            return firstArray[startIndex] == secondArray[startIndex];
        }

        // Check each element in the current segment for equality
        boolean elementsAreEqual = true;
        for (int k = startIndex; k < startIndex + length; k++) {
            if (firstArray[k] != secondArray[k]) {
                elementsAreEqual = false;
                break;
            }
        }

        // If the current segment matches, return true
        if (elementsAreEqual) {
            return true;
        }

        // If the length of the segment is odd, the arrays can't match symmetrically
        if (length % 2 != 0) {
            return false;
        }

        // Calculate the midpoint to divide the array segment into two halves
        int midpoint = length / 2;

        // Recursively check two possible conditions for matching segments
        boolean condition1 = recursiveMatchCheck(firstArray, secondArray, startIndex, midpoint) &&
                             recursiveMatchCheck(firstArray, secondArray, startIndex + midpoint, midpoint);
                             
        boolean condition2 = recursiveMatchCheck(firstArray, secondArray, startIndex, midpoint) &&
                             recursiveMatchCheck(firstArray, secondArray, startIndex, midpoint);

        // Return true if either condition is satisfied
        return condition1 || condition2;
    }
}


