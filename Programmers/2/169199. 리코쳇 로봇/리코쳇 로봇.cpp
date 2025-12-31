#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Node
{
    int x, y, cnt;
};

int solution(vector<string> board) {
    int n = board.size();
    int m = board[0].size();

    vector<vector<bool>> visited(n, vector<bool>(m, false));
    queue<Node> q;

    int startX = 0, startY = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (board[i][j] == 'R')
            {
                startX = i;
                startY = j;
            }
        }
    }

    q.push({startX, startY, 0});
    visited[startX][startY] = true;

    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    while (!q.empty())
    {
        Node cur = q.front();
        q.pop();

        if (board[cur.x][cur.y] == 'G')
        {
            return cur.cnt;
        }

        for (int d = 0; d < 4; d++)
        {
            int nx = cur.x;
            int ny = cur.y;

            while (true)
            {
                int tx = nx + dx[d];
                int ty = ny + dy[d];

                if (tx < 0 || ty < 0 || tx >= n || ty >= m) break;
                if (board[tx][ty] == 'D') break;

                nx = tx;
                ny = ty;
            }

            if (!visited[nx][ny])
            {
                visited[nx][ny] = true;
                q.push({nx, ny, cur.cnt + 1});
            }
        }
    }

    return -1;
}