import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = 0;
        
        int bestL = 0, bestR = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (right < sequence.length) {
            sum += sequence[right];
            
            while (sum >= k) {
                if (sum == k) {
                    int len = right - left + 1;
                    if (len < minLen) {
                        minLen = len;
                        bestL = left;
                        bestR = right;
                    }
                }
                
                sum -= sequence[left];
                left++;
            }
            
            right++;
        }        
        
        return new int[]{bestL, bestR};
    }
}