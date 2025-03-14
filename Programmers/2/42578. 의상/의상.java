import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        /* 
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String category = cloth[1];
            
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
        */
        
        return Arrays.stream(clothes)
            .collect(Collectors.groupingBy(cloth -> cloth[1], Collectors.counting()))
            .values()
            .stream()
            .map(count -> count + 1)
            .reduce(1L, (a, b) -> a * b)
            .intValue() - 1;
        }
}