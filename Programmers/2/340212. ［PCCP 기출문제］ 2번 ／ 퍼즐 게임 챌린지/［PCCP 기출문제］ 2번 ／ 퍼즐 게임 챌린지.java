class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            max = Math.max(max, diffs[i]);
        }
        
        int answer = max;
        
        int left = 1;
        int right = max;

        while (left < right) {
            int level = (left + right) / 2;
            long time = 0;
            
            time += times[0];
            
            for (int i = 1; i < times.length; i++) {
                if (diffs[i] > level) {
                    int num = diffs[i] - level;
                    
                    time = time + num * (times[i] + times[i - 1]) + times[i];

                    continue;
                }
                
                time += times[i];
            }
            
            if (time > limit) {
                left = level + 1;
                
                continue;
            }
            
            answer = Math.min(answer, level);
                
            right = level;
        }

        return answer;
    }
}