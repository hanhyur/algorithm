#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    vector<int> v;
    
    while (n > 0) {
        v.push_back(n % 3);
        n = n / 3;
    }
    
    reverse(v.begin(), v.end());
    
    answer += v[0] * 1;
    
    for (int i = 1; i < v.size(); i++) {
        if (v[i] == 0) {
            continue;
        }
        
        answer += v[i] * pow(3, i);
    }
    
    return answer;
}