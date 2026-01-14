#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> targets) {
    sort(targets.begin(), targets.end(),
        [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
    
    int answer = 0;
    long long last_shot = -1;
    
    for (const auto& t : targets)
    {
        int s = t[0];
        int e = t[1];
        
        if (last_shot <= s) {
            last_shot = e;
            ++answer;
        }
    }
    
    return answer;
}