#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer;
    
    for (char c : number)
    {
        while (k > 0 && !answer.empty() && answer.back() < c)
        {
            answer.pop_back();
            k--;
        }
        
        answer.push_back(c);
    }
    
    return answer.substr(0, answer.size() - k);
}