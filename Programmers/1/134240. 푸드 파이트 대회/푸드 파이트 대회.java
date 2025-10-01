import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        String half = "";
        
        for (int i = 1; i < food.length; i++) {
            int n = food[i] / 2;
            
            for (int j = 0; j < n; j++) {
                half += Integer.toString(i);   
            }
        }
        
        StringBuffer sb = new StringBuffer(half);
        String reverse = sb.reverse().toString();
        
        answer = half + "0" + reverse;
        
        return answer;
    }
}