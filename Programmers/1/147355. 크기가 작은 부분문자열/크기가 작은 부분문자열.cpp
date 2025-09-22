#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    long long tLen = t.size();
    long long pLen = p.size();
    
    for (int i = 0; i <= tLen - pLen; i++) {
        string str = t.substr(i, pLen);
        
        long long tNum = stoll(str);
        long long pNum = stoll(p);
        
        if (tNum <= pNum) {
            answer++;
        }
    }
    
    return answer;
}