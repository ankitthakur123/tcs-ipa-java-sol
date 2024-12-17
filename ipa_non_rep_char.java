// Find the first non repeated character substring
//Arijit = Arij

import java.util.Scanner;

public class ipa_non_rep_char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder uniqueChars = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (uniqueChars.indexOf(String.valueOf(ch)) != -1) { // Only add if not already in result
                break;
            }
            uniqueChars.append(ch);
        }
        
        System.out.println(uniqueChars.toString());

        /*String s = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i==j) {
                    s+=str.charAt(i);
                }
                else{
                    if (str.charAt(i)==str.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
            if (count>0) {
                break;
            }
        }
        System.out.println(s);*/
    }
}
