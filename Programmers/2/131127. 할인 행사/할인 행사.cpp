#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool check(const unordered_map<string, int>& target,
           const unordered_map<string, int>& win) 
{
    for (const auto& p : target)
    {
        if (win.count(p.first) == 0) return false;
        if (win.at(p.first) != p.second) return false;
    }
    
    return true;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    unordered_map<string, int> target;
    for (int i = 0; i < want.size(); i++)
        target[want[i]] = number[i];

    unordered_map<string, int> win;
    
    for (int i = 0; i < 10; i++)
        win[discount[i]]++;

    if (check(target, win))
        answer++;
    
    for (int i = 10; i < discount.size(); i++)
    {
        string out = discount[i - 10];
        string in  = discount[i];

        win[out]--;
        if (win[out] == 0)
            win.erase(out);

        win[in]++;

        if (check(target, win))
            answer++;
    }    
    
    return answer;
}