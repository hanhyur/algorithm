import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        
        Map<Integer, Integer> right = new HashMap<>();
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int t = topping[i];
            
            left.add(t);
            right.put(t, right.get(t) - 1);
            
            if (right.get(t) == 0) {
                right.remove(t);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}