#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> split(vector<int> arr, int start, int end) {
    vector<int> result;
    
    for (int i = start - 1; i < end; i++) {        
        result.push_back(arr[i]);
    }
    
    sort(result.begin(), result.end());
    
    return result;
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for (vector<int> command : commands) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        
        vector<int> temp = split(array, i, j);
        
        answer.push_back(temp[k - 1]);
    }
    
    return answer;
}