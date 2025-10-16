import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i + 1;
                
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), pressCount));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            
            for (char c : targets[i].toCharArray()) {
                if (!map.containsKey(c)) {
                    sum = -1;
                    break;
                }
                
                sum += map.get(c);
            }
            
            answer[i] = sum;
        }
        
        
        return answer;
    }
}