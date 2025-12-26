import java.util.*;

class Solution {
    
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') { sx = i; sy = j; }
                else if (c == 'L') { lx = i; ly = j; }
                else if (c == 'E') { ex = i; ey = j; }
            }
        }

        int distToLever = bfs(maps, sx, sy, lx, ly);
        if (distToLever == -1) return -1;

        int distToExit = bfs(maps, lx, ly, ex, ey);
        if (distToExit == -1) return -1;

        return distToLever + distToExit;
    }
    
    private int bfs(String[] maps, int sx, int sy, int tx, int ty) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == tx && cur.y == ty) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.dist + 1));
            }
        }

        return -1;
    }    
}