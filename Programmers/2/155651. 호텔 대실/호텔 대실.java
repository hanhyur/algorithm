import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]) + 10;
        }
        
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            
            pq.offer(time[1]);
        }
        
        return pq.size();
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}