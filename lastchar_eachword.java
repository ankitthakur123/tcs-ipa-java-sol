/* Last Character of each word of a sentence

 * Input: Kalyani Government Engineering College
 * Output: itge
 */
import java.util.Scanner;

public class lastchar_eachword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(arr[i].length()-1);
            System.out.print(c);
        }
    }
}
