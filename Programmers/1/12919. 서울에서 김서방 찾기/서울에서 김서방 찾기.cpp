#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    
    auto it = find(seoul.begin(), seoul.end(), "Kim");
    
    if (it != seoul.end()) {
        int index = distance(seoul.begin(), it);
        
        answer = "김서방은 " + to_string(index) + "에 있다";
    }
    
    return answer;
}