import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length;
        
        if (len / m == 0) {
            return 0;
        }
        
        int box = len / m;
        int count = 1;
        
        Arrays.sort(score);
        
        for (int i = len - 1; i >= 0; i--) {
            if (count == m) {
                count = 1;
                answer += score[i] * m;
                
                continue;
            }
            
            count++;
        }
        
        return answer;
    }
}