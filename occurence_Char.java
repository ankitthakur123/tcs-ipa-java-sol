/* Find the occurance of each character in a string
 * Input: Hello world
 * Output:
 *  H: 1
    e: 1
    l: 3
    o: 2
    w: 1
    r: 1
    d: 1
*/

import java.util.Scanner;

public class occurence_Char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') {
                continue;
            }
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
            }
            if(sb.indexOf(String.valueOf(s.charAt(i)))==-1){
                System.out.println(s.charAt(i)+": "+count);
            }
            sb.append(s.charAt(i));
        }
    }
}
