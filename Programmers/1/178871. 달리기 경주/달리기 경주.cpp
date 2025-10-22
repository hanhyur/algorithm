#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    unordered_map<string, int> rank;
    
    for (int i = 0; i < (int)players.size(); i++) 
    {
        rank[players[i]] = i;
    }

    for (const string& name : callings) 
    {
        int curIdx = rank[name];
        int frontIdx = curIdx - 1;

        string frontPlayer = players[frontIdx];
        swap(players[curIdx], players[frontIdx]);

        rank[name] = frontIdx;
        rank[frontPlayer] = curIdx;
    }

    return players;
}