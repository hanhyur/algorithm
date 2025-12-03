import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0, y = 0;
        int dir = 0;
        int num = 1;
        
        for (int len = n; len > 0; len--) {
            for (int i = 0; i < len; i++) {
                arr[x][y] = num++;
                
                if (i == len - 1) break;
                
                x += dx[dir];
                y += dy[dir];
            }
            
            dir = (dir + 1) % 3;
            x += dx[dir];
            y += dy[dir];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                result.add(arr[i][j]);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}