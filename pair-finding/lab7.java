import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class lab7 {
    
	public static boolean sortMethod(int[] inputArray) {

		Arrays.sort(inputArray);

		int leftIndex = 0;
		int rightIndex = inputArray.length-1;

		while (leftIndex < rightIndex) {

			int a = inputArray[leftIndex];
			int b = inputArray[rightIndex];

			if (a + b == 225) {return true;}
			else if (a + b < 225) {leftIndex++;}
			else if (a + b > 225) {rightIndex--;}
 
		}
		return false;
	}

	public static boolean secondArray(int[] inputArray) {
	
		boolean[] secondArray = new boolean[256];

		for (int i = 0; i < inputArray.length; i++) {

			if (inputArray[i] <= 225){
				
				secondArray[inputArray[i]] = true;
			
				if (secondArray[225 - inputArray[i]] == true) {return true;}
			
			}
		}
		return false;
	}

	public static int[] readArray(String filename) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get(filename));
		String line = lines.get(0);

		String[] strArray = line.split(" ");
		int[] intArray = new int[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}	

		return intArray;

	}

	public static void main(String[] args) throws IOException{
		
		int[] intArray = readArray("HasPair_10.txt");
		System.out.println("File HasPair_10.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();

		intArray = readArray("NoPair_10.txt");
		System.out.println("File NoPair_10.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();

		intArray = readArray("HasPair_100000.txt");
		System.out.println("File HasPair_100000.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();

		intArray = readArray("NoPair_100000.txt");
		System.out.println("File NoPair_100000.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();

		intArray = readArray("HasPair_1000000.txt");
		System.out.println("File HasPair_100000.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();

		intArray = readArray("NoPair_1000000.txt");
		System.out.println("File NoPair_1000000.txt");
		System.out.println("Second Array method  :  "  + secondArray(intArray));
		System.out.println();
  	}
	
}