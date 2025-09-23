#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int maxWidth = 1;
    int maxHeight = 1;
    
    for (vector<int> size : sizes)
    {
        if (size[0] < size[1]) {
            int tmp = size[0];
            size[0] = size[1];
            size[1] = tmp;
        }
        
        maxWidth = max(size[0], maxWidth);
        maxHeight = max(size[1], maxHeight);
    }
    
    answer = maxWidth * maxHeight;
    
    return answer;
}