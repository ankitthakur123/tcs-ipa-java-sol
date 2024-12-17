/* Input: "Hello@123World456"

Process:
Array: ["Hello", "@", "123", "World", "456"]
Now you should concatenate all the strings in the array and multiply it with the sum of the position of that array where 
numbers are stored.
Sum of positions of numbers in the array = 3 + 5 = 8
Concatenated string = "Hello@123World456"
Result = 8 * "Hello@123World456" = "Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456
Hello@123World456Hello@123World456Hello@123World456"

Output:
"Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456
Hello@123World456"

*/

import java.util.Arrays;
import java.util.Scanner;

public class print_repeat_string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();
        
        // Split the input into an array based on any non-alphabetic characters
        String[] array = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)");

        StringBuilder concatenatedString = new StringBuilder();
        int sumOfPositions = 0;
        System.out.println(Arrays.toString(array));
        // Process each element of the array
        for (int i = 0; i < array.length; i++) {
            concatenatedString.append(array[i]);
            if (array[i].matches("\\d+")) { // Check if the element is a number
                sumOfPositions += (i + 1);  // Sum the positions (1-based index)
            }
        }

        // Generate the result by repeating the concatenated string 'sumOfPositions' times
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sumOfPositions; i++) {
            result.append(concatenatedString);
        }

        System.out.println("Output: " + result.toString());
    }
}
