#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    
    for (char c : s) {
        if (islower(c))
        {
            c = (char) ((c + n % 26 - 'a') % 26 + 'a');
        }
        else if (isupper(c))
        {
            c = (char) ((c + n % 26 - 'A') % 26 + 'A');
        }
        
        answer.push_back(c);
    }
    
    return answer;
}