#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    int n = sequence.size();
    int left = 0, right = 0, sum = 0;
    
    int bestL = 0, bestR = 0;
    int minLen = 1e9;
    
    while (right < n)
    {
        sum += sequence[right];
        
        while (sum >= k)
        {
            if (sum == k)
            {
                int len = right - left + 1;
                
                if (len < minLen)
                {
                    minLen = len;
                    bestL = left;
                    bestR = right;
                }
            }
            
            sum -= sequence[left];
            left++;
        }
        
        right++;
    }
    
    return {bestL, bestR};
}