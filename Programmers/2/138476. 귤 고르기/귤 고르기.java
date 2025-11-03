import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int total = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(countMap.values());
        
        counts.sort(Collections.reverseOrder());
        
        for (int c : counts) {
            total += c;
            answer++;
            
            if (total >= k) break;
        }
        
        return answer;
    }
}