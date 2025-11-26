#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> topping) {
    int n = topping.size();
    
    unordered_map<int, int> right;
    for (int t : topping) right[t]++;
    
    unordered_set<int> left;
    
    int answer = 0;
    
    for (int i = 0; i < n - 1; i++)
    {
        int t = topping[i];
        
        left.insert(t);
        right[t]--;
        
        if (right[t] == 0) right.erase(t);
        if (left.size() == right.size()) answer++;
    }
    
    return answer;
}