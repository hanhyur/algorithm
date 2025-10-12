#include <string>
#include <vector>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
    vector<string> possible = {"aya", "ye", "woo", "ma"};
    
    for (string b : babbling)
    {
        bool invalid = false;
        
        for (string p : possible)
        {
            if (b.find(p + p) != string::npos)
            {
                invalid = true;
                break;
            }
            
            size_t pos = 0;
            while ((pos = b.find(p, pos)) != string::npos)
            {
                b.replace(pos, p.length(), "*");
            }
        }
        
        if (!invalid && b.find_first_not_of("*") == string::npos)
        {
            answer++;
        }
    }
    
    return answer;
}