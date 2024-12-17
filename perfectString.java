import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**The problem describes two strings, s and t, each of length n. 
 * The goal is to determine if you can transform string s 
 * into a "perfect string" by making it identical to string t through a series of operations. 
 * The operations allowed are as follows:

Swap any character in s with any character in t.
Swapping within the same string (s or t) is not allowed. 
For s = "abcd" and t = "abcs": output is: 0(false)
*/
public class perfectString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases
        for (int t_i = 0; t_i < T; t_i++) {
            int n = Integer.parseInt(br.readLine().trim()); // Size of the strings
            String s = br.readLine().trim();
            String t = br.readLine().trim();

            boolean result = solve(n, s, t);
            wr.println(result ? "1" : "0");
        }

        wr.close();
        br.close();
    }
    public static boolean solve(int n, String s, String t){
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        // Count character frequencies for both strings
        for (int i = 0; i < n; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        // Compare frequency arrays
        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) {
                return false;
            }
        }

        // If all character frequencies match, it is possible to transform s into t
        return true;
    }
}
