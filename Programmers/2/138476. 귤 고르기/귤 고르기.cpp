#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    unordered_map<int, int> count;
    for (int t : tangerine)
        count[t]++;

    vector<int> freq;
    for (auto &p : count)
        freq.push_back(p.second);

    sort(freq.begin(), freq.end(), greater<int>());

    int total = 0;
    for (int f : freq)
    {
        total += f;
        answer++;
        
        if (total >= k) break;
    }    
    
    return answer;
}