#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = false;
    
    if (s.size() == 4 || s.size() == 6)
    {
        int i;
        
        for (i = 0; i < s.size(); i++)
        {
            if (!isdigit(s[i])) {
                break;
            }
        }
        
        if (i == s.size()) answer = true;
    }
    
    return answer;
}