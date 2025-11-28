#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(vector<int> numbers) {
    vector<string> arr;
    arr.reserve(numbers.size());
    
    for (int n : numbers)
    {
        arr.push_back(to_string(n));
    }
    
    sort(arr.begin(), arr.end(),
        [](const string& a, const string& b) {
            return b + a < a + b;
        });
    
    string result;
    for (auto& s : arr) result += s;
    
    if (result[0] == '0') return "0";
    
    return result;
}