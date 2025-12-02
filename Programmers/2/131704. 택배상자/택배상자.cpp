#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> st;
    int cur = 1;
    
    for (int o : order)
    {
        while (cur <= o)
        {
            st.push(cur);
            cur++;
        }
        
        if (!st.empty() && st.top() == o)
        {
            st.pop();
            answer++;
        }
        else
        {
            break;
        }
    }
    
    return answer;
}