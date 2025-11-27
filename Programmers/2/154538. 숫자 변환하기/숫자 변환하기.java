import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        q.add(new int[]{x, 0});
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int value = cur[0];
            int count = cur[1];
            
            if (value == y) return count;
            
            int[] nexts = {value + n, value * 2, value * 3};
            
            for (int next : nexts) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }
        
        return -1;
    }
}