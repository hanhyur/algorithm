import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        
        for (int o : order) {
            while (current <= o) {
                stack.push(current);
                current++;
            }
            
            if (!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}