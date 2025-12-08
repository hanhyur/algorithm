#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> maps) {
    int n = maps.size();
    int m = maps[0].size();
    
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    vector<int> answer;
    
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};
    
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (maps[i][j] == 'X' || visited[i][j])
                continue;
            
            int sum = 0;
            queue<pair<int, int>> que;
            visited[i][j] = true;
            que.push({i, j});
            sum += maps[i][j] - '0';
            
            while (!que.empty())
            {
                auto [x, y] = que.front();
                que.pop();
                
                for (int d = 0; d < 4; d++)
                {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;
                    if (visited[nx][ny] || maps[nx][ny] == 'X')
                        continue;
                    
                    visited[nx][ny] = true;
                    que.push({nx, ny});
                    sum += maps[nx][ny] - '0';
                }
            }
            
            answer.push_back(sum);
        }
    }
    
    if (answer.empty()) return vector<int>{-1};
    
    sort(answer.begin(), answer.end());
    return answer;
}