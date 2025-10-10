class Solution {
    public int countDivisor(int n) {
        int count = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                count++;
            } else if (n % i == 0) {
                count += 2;
            }
        }
        
        return count;
    }
    
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int n = 1; n <= number; n++) {
            int cnt = countDivisor(n);
            
            if (cnt > limit) {
                answer += power;
                continue;
            }
            
            answer += cnt;
        }
                
        return answer;
    }
}