#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    for (long long h = 1; h * h <= yellow; ++h)
    {
        if (yellow % h == 0)
        {
            long long w = yellow / h;
            
            int totalW = w + 2;
            int totalH = h + 2;
            
            int brownCount = totalW * totalH - yellow;
            
            if (brownCount == brown)
            {
                return { (int)totalW, (int)totalH };
            }
        }
    }
    
    return answer;
}