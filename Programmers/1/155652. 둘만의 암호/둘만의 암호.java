import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipSet = new HashSet<>();
        
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = 0;
            char current = c;

            while (count < index) {
                current++;
                if (current > 'z') current = 'a';

                if (!skipSet.contains(current)) {
                    count++;
                }
            }
            
            result.append(current);
        }

        answer = result.toString();
        
        return answer;
    }
}