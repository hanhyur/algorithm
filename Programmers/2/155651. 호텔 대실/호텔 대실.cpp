#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int toMinutes(const string& time)
{
    int hour = stoi(time.substr(0, 2));
    int minute = stoi(time.substr(3, 2));
    
    return hour * 60 + minute;
}

int solution(vector<vector<string>> book_time) {
    vector<pair<int, int>> times;
    
    for (const auto& b : book_time)
    {
        int start = toMinutes(b[0]);
        int end = toMinutes(b[1]) + 10;
        times.emplace_back(start, end);
    }
    
    sort(times.begin(), times.end());
    
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for (const auto& t : times)
    {
        if (!pq.empty() && pq.top() <= t.first)
        {
            pq.pop();
        }
        
        pq.push(t.second);
    }
    
    return pq.size();
}