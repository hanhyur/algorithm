#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    
    sort(data.begin(), data.end(), [&](const vector<int>& a, const vector<int>& b) {
        if (a[col - 1] != b[col - 1]) return a[col - 1] < b[col - 1];
        
        return a[0] > b[0];
    });
    
    for (int i = row_begin; i <= row_end; i++)
    {
        int sum = 0;
        const auto& row = data[i - 1];
        
        for (int v : row)
        {
            sum += (v % i);
        }
        
        answer ^= sum;
    }
    
    return answer;
}