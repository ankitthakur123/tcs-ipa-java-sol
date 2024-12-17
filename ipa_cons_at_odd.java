import java.util.Scanner;

public class ipa_cons_at_odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                char c = s.charAt(i);
                if (Character.isLetter(c)&&"aeiouAEIOU".indexOf(c)==-1) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
