import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        /*
        String[] stringNumbers = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if (stringNumbers[0].equals("0")) return "0";
        
        return String.join("", stringNumbers);
        */
        
        String answer = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining());
        
        return answer.startsWith("0") ? "0" : answer;
    }
}