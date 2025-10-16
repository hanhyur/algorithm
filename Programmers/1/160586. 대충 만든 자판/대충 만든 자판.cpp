#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    unordered_map<char, int> map;
    
    for (const string& key : keymap)
    {
        for (int i = 0; i < key.size(); i++)
        {
            char c = key[i];
            int pressCount = i + 1;
            
            if (map.find(c) == map.end())
            {
                map[c] = pressCount;
            }
            else
            {
                map[c] = min(map[c], pressCount);
            }
        }
    }
    
    for (const string& target : targets)
    {
        int sum = 0;
        bool impossible = false;
        
        for (char c : target)
        {
            if (map.find(c) == map.end())
            {
                sum = -1;
                impossible = true;
                break;
            }
            
            sum += map[c];
        }
        
        answer.push_back(impossible ? -1 : sum);
    }
    
    return answer;
}