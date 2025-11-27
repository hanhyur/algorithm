#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int x, int y, int n) {
    queue<pair<int, int>> q;
    vector<bool> visited(y + 1, false);
    
    q.push({x, 0});
    visited[x] = true;
    
    while (!q.empty())
    {
        auto [value, count] = q.front();
        q.pop();
        
        if (value == y) return count;
        
        int nexts[3] = {value + n, value * 2, value * 3};
        
        for (int next : nexts)
        {
            if (next <= y && !visited[next])
            {
                visited[next] = true;
                q.push({next, count + 1});
            }
        }
    }
    
    return -1;
}