import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String first = br.readLine();
        String second = br.readLine();
        
        int[] firstCountArr = getAlphabetCount(first);
        int[] secondCountArr = getAlphabetCount(second);
        
        for (int i = 0; i < 26; i++) {
            countDiffBetweenArr(i, firstCountArr, secondCountArr);
        }
        
        System.out.println(answer);
    }
    
    public static int[] getAlphabetCount(String str) {
        int[] countArr = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i) - 'a']++;
        }
        
        return countArr;
    }
    
    private static void countDiffBetweenArr(int i, int[] first, int[] second) {
        if (first[i] != second[i]) {
            answer += Math.abs(first[i] - second[i]);
        }
    }
}