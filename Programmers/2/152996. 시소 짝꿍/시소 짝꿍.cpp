#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    unordered_map<int, long long> cnt;
    
    for (int w : weights) cnt[w]++;
    
    for (auto& [w, c] : cnt)
    {
        if (c >= 2) answer += c * (c - 1) / 2;
    }
    
    for (auto& [w, c] : cnt)
    {
        if (w * 2 % 3 == 0 && cnt.count(w * 2 / 3))
            answer += c * cnt[w * 2 / 3];
        
        if (w * 2 % 4 == 0 && cnt.count(w * 2 / 4))
            answer += c * cnt[w * 2 / 4];
        
        if (w * 3 % 4 == 0 && cnt.count(w * 3 / 4))
            answer += c * cnt[w * 3 / 4];
    }
    
    return answer;
}