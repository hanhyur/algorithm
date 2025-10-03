#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    vector<int> hof;
    
    for (int i = 0; i < score.size(); i++)
    {
        hof.push_back(score[i]);
        
        sort(hof.begin(), hof.end());
        
        if (hof.size() > k)
        {
            hof.erase(hof.begin() + 0);
        }
        
        answer.push_back(hof[0]);
    }
    
    return answer;
}