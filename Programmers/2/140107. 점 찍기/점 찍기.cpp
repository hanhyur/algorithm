#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    
    for (int i = 0; i <= d / k; i++)
    {
        int x = i * k;
        int y = (int) sqrt(pow(d, 2) - pow(x, 2)) / k;
        
        answer += y + 1;
    }
    
    return answer;
}