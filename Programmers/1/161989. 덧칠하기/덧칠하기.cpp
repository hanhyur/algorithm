#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    int end = 0;
    
    for (int num : section)
    {
        if (num > end)
        {
            answer++;
            end = num + m - 1;
        }
    }
    
    return answer;
}