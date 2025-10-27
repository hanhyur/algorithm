import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart) {
                answer.append(Character.isLetter(c) ? Character.toUpperCase(c) : c);
            } else {
                answer.append(Character.isLetter(c) ? Character.toLowerCase(c) : c);
            }
            
            isStart = (c == ' ');
        }

        return answer.toString();
    }
}