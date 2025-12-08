import java.util.*;

class Solution {
    static class Node {
        int x, y, dir, cost;
        
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int[][][] cost = new int[n][n][4];
        
        for (int[][] arr : cost) {
            for (int[] a : arr)
                Arrays.fill(a, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        
        
        for (int d = 0; d < 4; d++) {
            cost[0][0][d] = 0;
            
            pq.offer(new Node(0, 0, d, 0));
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.x == n - 1 && cur.y == n - 1)
                return cur.cost;
            
            for (int nd = 0; nd < 4; nd++) {
                int nx = cur.x + dx[nd];
                int ny = cur.y + dy[nd];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (board[nx][ny] == 1)
                    continue;
                
                int nextCost = cur.cost + 100;
                
                if (cur.dir != nd)
                    nextCost += 500;
                
                if (cost[nx][ny][nd] > nextCost) {
                    cost[nx][ny][nd] = nextCost;
                    
                    pq.offer(new Node(nx, ny, nd, nextCost));
                }
            }
        }
        
        return -1;
    }
}