import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        
        int[] answer = new int[n];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                answer[i] = i - map.get(c);
            } else {
                answer[i] = -1;
            }
            
            map.put(c, i);
        }
        
        return answer;
    }
}