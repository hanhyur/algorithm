import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : scoville) {
            pq.add(num);
        }
        
        while (pq.size() > 1 && pq.peek() < k) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second * 2);
            
            answer++;
        }
        
        return pq.peek() >= k ? answer : -1;
    }
}