import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X' || visited[i][j])
                    continue;
                
                int sum = 0;
                Queue<int[]> que = new LinkedList<>();
                
                visited[i][j] = true;
                que.offer(new int[]{i, j});
                sum += maps[i].charAt(j) - '0';
                
                while (!que.isEmpty()) {
                    int[] cur = que.poll();
                    int x = cur[0], y = cur[1];
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        
                        if (nx < 0 || nx >= n)
                            continue;
                        if (ny < 0 || ny >= m)
                            continue;
                        if (visited[nx][ny] || maps[nx].charAt(ny) == 'X')
                            continue;
                        
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                        sum += maps[nx].charAt(ny) - '0';
                    }
                }
                
                result.add(sum);
            }
        }
        
        if (result.isEmpty()) return new int[]{-1};
        
        Collections.sort(result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}