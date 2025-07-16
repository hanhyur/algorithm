import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        
        Deque<Integer> q1 = new ArrayDeque();
        Deque<Integer> q2 = new ArrayDeque();
        
        long total1 = 0, total2 = 0;
        
        for (int i = 0; i < n; i++) {
            total1 += queue1[i];
            q1.add(queue1[i]);
        }
        
        for (int i = 0; i < n; i++) {
            total2 += queue2[i];
            q2.add(queue2[i]);
        }
        
        for (int i = 0; i < 4 * n + 1; i++) {
            if (total1 == total2) return i;
            
            if (total1 < total2) {
                int x = q2.getFirst();
                total1 += x;
                total2 -= x;
                q1.add(x);
                q2.removeFirst();
            } else {
                int x = q1.getFirst();
                total2 += x;
                total1 -= x;
                q2.add(x);
                q1.removeFirst();
            }
        }
        
        return -1;
    }
}