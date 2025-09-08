#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int min = *min_element(arr.begin(), arr.end());
    
    if (arr.size() == 1) {
        arr[0] = -1;
        return arr;
    }
    
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == min) {
            continue;
        }
        
        answer.push_back(arr[i]);
    }
    
    return answer;
}