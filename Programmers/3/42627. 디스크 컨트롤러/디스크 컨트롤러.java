import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int time = 0;
        int totalTime = 0;
        int jobIndex = 0;
        int count = jobs.length;
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while (jobIndex < count || !pq.isEmpty()) {
            while (jobIndex < count && jobs[jobIndex][0] <= time) {
                pq.add(jobs[jobIndex++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[jobIndex][0];
                
                continue;
            }
            
            int[] job = pq.poll();
                
            time += job[1];
            totalTime += time - job[0];
        }
        
        return totalTime / count;
    }
}