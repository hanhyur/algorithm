#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int answer = 0;

void dfs(int stamina, const vector<vector<int>>& dungeon, vector<bool>& visited, int count)
{
    answer = max(answer, count);
    
    for (int i = 0; i < dungeon.size(); i++)
    {
        int need = dungeon[i][0];
        int cost = dungeon[i][1];
        
        if (visited[i] || stamina < need) continue;
        
        visited[i] = true;
        
        dfs(stamina - cost, dungeon, visited, count + 1);
        
        visited[i] = false;
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    vector<bool> visited(dungeons.size(), false);
    
    dfs(k, dungeons, visited, 0);
    
    return answer;
}