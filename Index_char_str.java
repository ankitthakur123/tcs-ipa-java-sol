/* Find the index number of a character in a String
 * Input1 :
 --------------
  Carrot
  a
 
 * Output:
 ---------------
   1

 * Input2:
 ----------------
   Carrot
   z

 * Output:
  --------------
   NA
 */

import java.util.Scanner;

public class Index_char_str {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.nextLine().charAt(0);
        /*boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch==c) {
                System.out.println(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("NA");
        }*/
        int index = s.indexOf(c);
        
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("NA");
        }
    }
}
