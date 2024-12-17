/* Find largest word from a given sentence
 * 
 Input: He is so funny boy
 Output: funny
 */

import java.util.Scanner;

public class LargestWord_sentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int max = arr[0].length();
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length()>max) {
                max = arr[i].length();
                ans = i;
            }
        }
        System.out.println(arr[ans]);
    }
}
