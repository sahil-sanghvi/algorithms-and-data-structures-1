import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ArrayMatch {

    public static void main(String[] args) {

        if (args.length > 0) {
            String filename = args[0];
            
            // creating and giving the arrays values from the input files
            int[][] arrays = readArraysFromFile(filename);

            if (arrays != null) {
                int[] A = arrays[0];
                int[] B = arrays[1];

                if (match(A, B)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } else {
            System.out.println("Please provide a filename");
        }
    }

    // Method to read the file and populate arrays
    public static int[][] readArraysFromFile(String filename) {
        try {
            FileInputStream in = new FileInputStream(filename);
            Scanner scanner = new Scanner(in);

            int n = scanner.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = scanner.nextInt();
            }
            scanner.close();

            return new int[][] {A, B};
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }

    public static boolean match(int[] A, int[] B) {
        return checkForMatch(A, B, 0, A.length);
    }

    private static boolean checkForMatch(int[] A, int[] B, int index, int length) {
        if (length == 1) {
            return A[index] == B[index];
        }

        boolean is_equal = true;
        for (int i = index; i < index + length; i++) {
            if (A[i] != B[i]) {
                is_equal = false;
                break;
            }
        }
        if (is_equal) {
            return true;
        }

        if (length % 2 != 0) {
            return false;
        }

        int mid = length / 2;
        boolean condition1 = checkForMatch(A, B, index, mid) && checkForMatch(A, B, index + mid, mid);
        boolean condition2 = checkForMatch(A, B, index, mid) && checkForMatch(A, B, index, mid);

        return condition1 || condition2;
    }
}
