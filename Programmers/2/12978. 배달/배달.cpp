#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Node
{
    int to, cost;
};

int solution(int N, vector<vector<int> > road, int K) {
    vector<vector<Node>> graph(N + 1);
    
    for (auto &r : road)
    {
        int a = r[0], b = r[1], c = r[2];
        
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }
    
    vector<int> dist(N + 1, INT_MAX);
    dist[1] = 0;
    
    priority_queue<pair<int,int>,
                  vector<pair<int,int>>,
                  greater<pair<int,int>>
    > pq;
    
    pq.push({0, 1});
    
    while (!pq.empty())
    {
        auto [cost, node] = pq.top();
        pq.pop();
        
        if (cost > dist[node]) continue;
        
        for (auto &next : graph[node])
        {
            int newCost = cost + next.cost;
            
            if (newCost < dist[next.to])
            {
                dist[next.to] = newCost;
                pq.push({newCost, next.to});
            }
        }
    }
    
    int answer = 0;
    for (int i = 1; i <= N; i++)
    {
        if (dist[i] <= K)
            answer++;
    }
    
    return answer;
}