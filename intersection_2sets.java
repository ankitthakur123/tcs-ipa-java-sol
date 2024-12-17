/*calculate the intersection of these two sets and print the result
 * Set 1 :
1 : 3
2 : 5
3 : 7
4 : 9
Set 2 :
1 : 5
2 : 9
3 : 11
4 : 13
5 : 7
The intersection of the two sets : [5, 7, 9]
 */

import java.util.Arrays;
import java.util.Scanner;

public class intersection_2sets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] set1 = new int[4];
        int[] set2 = new int[5];
        int[] intersection = new int[0];
        System.out.println("Set 1 :");
        for (int i = 0; i < set1.length; i++) {
            System.out.print((i+1)+" : ");
            set1[i] = sc.nextInt();
        }
        System.out.println("Set 2 :");
        for (int i = 0; i < set2.length; i++) {
            System.out.print((i+1)+" : ");
            set2[i] = sc.nextInt();
        }
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if (set1[i]==set2[j]) {
                    intersection = Arrays.copyOf(intersection, intersection.length+1);
                    intersection[intersection.length-1] = set1[i];
                }
            }
        }
        System.out.println("The intersection of the two sets : "+Arrays.toString(intersection));
    }
}
