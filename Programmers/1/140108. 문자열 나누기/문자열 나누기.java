import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char x = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                same++;
            } else {
                diff++;
            }
            
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
                
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
            }
        }
        
        if (same != diff) {
            answer++;
        }
        
        return answer;
    }
}