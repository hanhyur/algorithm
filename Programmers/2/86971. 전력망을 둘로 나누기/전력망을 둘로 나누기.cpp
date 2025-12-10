#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int bfsCount(int start, int blockU, int blockV, vector<vector<int>>& graph, int n)
{
    queue<int> q;
    vector<bool> visited(n + 1, false);
    
    q.push(start);
    visited[start] = true;
    int count = 1;
    
    while (!q.empty())
    {
        int cur = q.front();
        q.pop();
        
        for (int next : graph[cur])
        {
            if ((cur == blockU && next == blockV) ||
               (cur == blockV && next == blockU))
                continue;
            
            if (!visited[next])
            {
                visited[next] = true;
                q.push(next);
                count++;
            }
        }
    }
    
    return count;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = INT_MAX;
    vector<vector<int>> graph(n + 1);
    
    for (auto& w : wires)
    {
        graph[w[0]].push_back(w[1]);
        graph[w[1]].push_back(w[0]);
    }
    
    for (auto& cut : wires)
    {
        int a = bfsCount(cut[0], cut[0], cut[1], graph, n);
        int b = n - a;
        answer = min(answer, abs(a - b));
    }
    
    return answer;
}