#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    sort(lottos.begin(), lottos.end());
    sort(win_nums.begin(), win_nums.end());
    
    int zero = count(lottos.begin(), lottos.end(), 0);
    int winning = 0;
    
    for (int lotto : lottos)
    {
        if (lotto == 0) 
            continue;
        
        if (find(win_nums.begin(), win_nums.end(), lotto) != win_nums.end())
        {
            winning++;
        }
    }
    
    int maxRank = min(6, 6 - (winning + zero) + 1);
    int minRank = min(6, 6 - winning + 1);
    
    return {maxRank, minRank};
}