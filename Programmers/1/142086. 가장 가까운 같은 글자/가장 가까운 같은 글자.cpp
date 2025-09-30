#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    
    int n = s.size();
    map<char, int> m;
    
    for (int i = 0; i < n; i++) {
        char c = s[i];
            
        if (m.find(c) != m.end()) {
            answer.push_back(i - m[c]);
        } else {
            answer.push_back(-1);
        }
            
        m[c] = i;
    }
    
    return answer;
}