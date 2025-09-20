#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int cnt = 0;
    
    for(char c : s) {
        if (c == ' ') {
            cnt = 0;
            answer.push_back(c);
            continue;
        }
        
        c = cnt % 2 == 0 ? toupper(c) : tolower(c);
        
        answer.push_back(c);
        
        cnt++;
    }
    
    return answer;
}