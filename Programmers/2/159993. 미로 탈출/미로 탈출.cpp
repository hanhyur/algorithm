#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Point {
    int x, y, dist;
};

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int bfs(const vector<string>& maps, int sx, int sy, int tx, int ty) {
    int n = maps.size();
    int m = maps[0].size();
    vector<vector<bool>> visited(n, vector<bool>(m, false));

    queue<Point> q;
    q.push({sx, sy, 0});
    visited[sx][sy] = true;

    while (!q.empty()) {
        auto cur = q.front(); q.pop();

        if (cur.x == tx && cur.y == ty)
            return cur.dist;

        for (int d = 0; d < 4; d++) {
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) continue;
            if (maps[nx][ny] == 'X') continue;

            visited[nx][ny] = true;
            q.push({nx, ny, cur.dist + 1});
        }
    }
    return -1;
}

int solution(vector<string> maps) {
    int n = maps.size();
    int m = maps[0].size();

    int sx, sy, lx, ly, ex, ey;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (maps[i][j] == 'S') { sx = i; sy = j; }
            else if (maps[i][j] == 'L') { lx = i; ly = j; }
            else if (maps[i][j] == 'E') { ex = i; ey = j; }
        }
    }

    int d1 = bfs(maps, sx, sy, lx, ly);
    if (d1 == -1) return -1;

    int d2 = bfs(maps, lx, ly, ex, ey);
    if (d2 == -1) return -1;

    return d1 + d2;
}