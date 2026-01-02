import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            maxHeap.offer(enemy[i]);
            
            if (n < 0) {
                if (k <= 0)
                    return i;
                
                int largest = maxHeap.poll();
                n += largest;
                k--;
                
                if (n < 0)
                    return i;
            }
        }
        
        return enemy.length;
    }
}