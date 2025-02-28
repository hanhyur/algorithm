import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(participant)
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        
        Arrays.stream(completion).forEach(c -> map.put(c, map.get(c) - 1));
        
        return map.entrySet().stream()
            .filter(entry -> entry.getValue() > 0)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse("");
    }
}