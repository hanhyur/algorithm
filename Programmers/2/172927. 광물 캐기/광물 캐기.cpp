#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Group
{
    int d, i, s;
    int score;
};

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    int totalPicks = picks[0] + picks[1] + picks[2];
    int limit = min((int)minerals.size(), totalPicks * 5);

    vector<Group> groups;
    
    for (int idx = 0; idx < limit; idx += 5)
    {
        int d = 0, ir = 0, st = 0;
        
        for (int k = idx; k < idx + 5 && k < limit; k++)
        {
            const string& m = minerals[k];
            
            if (m == "diamond") d++;
            else if (m == "iron") ir++;
            else st++;
        }
        
        groups.push_back({d, ir, st, 25 * d + 5 * ir + st});
    }

    sort(groups.begin(), groups.end(), [](const Group& a, const Group& b) {
        return a.score > b.score;
    });    
    
    for (const auto& g : groups)
    {
        int pickType = -1;
            
        if (picks[0] > 0) { pickType = 0; picks[0]--; }
        else if (picks[1] > 0) { pickType = 1; picks[1]--; }
        else if (picks[2] > 0) { pickType = 2; picks[2]--; }
        else break;

        if (pickType == 0)
        {
            answer += (g.d + g.i + g.s);
        } 
        else if (pickType == 1)
        {
            answer += 5 * g.d + (g.i + g.s);
        } 
        else
        {
            answer += 25 * g.d + 5 * g.i + g.s;
        }
    }    
    
    return answer;
}