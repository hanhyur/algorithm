import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[] countArr = new int[26];
    static int max = -1;
    static char answer = '?';
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine().toUpperCase();
        
        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i) - 'A']++;
            getAlphabet(str, i);
        }
        
        System.out.println(answer);
    }
    
    public static void getAlphabet(String str, int i) {
        if (countArr[str.charAt(i) - 'A'] > max) {
            max = countArr[str.charAt(i) - 'A'];
            answer = str.charAt(i);
        }
        
        if (countArr[str.charAt(i) - 'A'] == max && answer != str.charAt(i)) {
            answer = '?';
        }
    }
    
}
