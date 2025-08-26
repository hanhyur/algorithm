#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    string str = to_string(n);
    sort(str.begin(), str.end(), greater<char>());
    answer = stoll(str);

    return answer;
    
//     string str = to_string(n);
//     vector<int> digits;
    
//     for (char c : str) {
//         digits.push_back(c - '0');
//     }
    
//     sort(digits.begin(), digits.end(), greater<int>());
    
//     for (int num : digits) {
//         answer += num;
//         answer *= 10;
//     }
    
//     return answer / 10;
}