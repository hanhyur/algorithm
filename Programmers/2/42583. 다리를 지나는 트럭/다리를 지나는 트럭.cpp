#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<int> bridge;
    int time = 0;
    int curWeight = 0;
    
    for (int i = 0; i < bridge_length; i++) bridge.push(0);
    
    int idx = 0;
    
    while (idx < truck_weights.size())
    {
        time++;
        
        curWeight -= bridge.front();
        bridge.pop();
        
        if (curWeight + truck_weights[idx] <= weight)
        {
            bridge.push(truck_weights[idx]);
            curWeight += truck_weights[idx];
            idx++;
        }
        else
        {
            bridge.push(0);
        }
    }
    
    return time + bridge_length;
}