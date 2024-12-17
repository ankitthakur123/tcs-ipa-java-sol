import java.util.Scanner;

public class ipa_1st_non_repchar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                System.out.println(s.charAt(i));
                return;
            }
        }
    }
 }

