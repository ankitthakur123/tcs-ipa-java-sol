/* Marge two strings using comma

Input: 
Arijit,Ghosh
Pop:Mom

Output:
Arijit, Ghosh, Pop:Mom
*/

import java.util.Scanner;
import java.util.Arrays;
public class mergewords{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        /*String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        for (int i = 0; i < str2.length; i++) {
            str1 = Arrays.copyOf(str1, str1.length+1);
            str1[str1.length-1] = str2[i];
        }
        String n = Arrays.toString(str1);
        String k = n.substring(1,n.length()-1);
        System.out.println(k);*/
        String result = s1 + ", " + s2;
        
        System.out.println(result);
    }
}