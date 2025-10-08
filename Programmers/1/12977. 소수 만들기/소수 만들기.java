import java.util.*;

class Solution {
    boolean[] prime = new boolean[3001];
    
    public void isPrime() {
        prime[0] = false;				
        prime[1] = false;

        for(int i = 2; i <= Math.sqrt(3000); i++) {
            if(prime[i] == true) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        
        isPrime();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    
                    if (!prime[num]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}