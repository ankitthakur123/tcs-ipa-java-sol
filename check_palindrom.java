import java.util.Scanner;

public class check_palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        /*StringBuilder sb = new StringBuilder(s);
        String ans = sb.reverse().toString();
        if(s.equals(ans)){
            System.out.println("Palindrom");
        }else System.out.println("None");*/
        String[] str = s.split(" ");
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (check_palindrom(str[i])) {
                count++;
                System.out.println(str[i]);
            }
        }
        System.out.println(count);

    }
    public static boolean check_palindrom(String s){
        StringBuilder sb = new StringBuilder(s);
        String ans = sb.reverse().toString();
        if(s.equals(ans)){
            return true;
        }
        return false;
    }
}
