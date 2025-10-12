import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            boolean invalid = false;

            for (String p : possible) {
                if (b.contains(p + p)) {
                    invalid = true;
                    break;
                }
                
                b = b.replace(p, "*");
            }

            if (!invalid && b.replace("*", "").isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}