#include <string>
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    answer.reserve(numbers.size());
    
    for (long long x : numbers)
    {
        if ((x & 1LL) == 0)
        {
            answer.push_back(x + 1);
            continue;
        }
        
        long long bit = 1LL;
        
        while (x & bit)
        {
            bit <<= 1;
        }
        
        long long result = x + bit - (bit >> 1);
        answer.push_back(result);
    }
    
    return answer;
}