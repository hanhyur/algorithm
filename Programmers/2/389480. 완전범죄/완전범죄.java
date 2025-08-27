class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        
        int thingCount = info.length;
        int[] dp = new int[m];
        
        int maxATrace = 0;
        for (int i = 0; i < thingCount; i++) {
            maxATrace += info[i][0];
        }
        
        for (int i = 0; i < thingCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            
            for (int j = m - 1; j >= bTrace; j--) {
                dp[j] = Math.max(dp[j], dp[j - bTrace] + aTrace);
            }
        }
        
        answer = maxATrace - dp[m - 1];
        return answer >= n ? -1 : answer;
    }
}