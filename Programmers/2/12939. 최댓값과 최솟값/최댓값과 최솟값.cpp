#include <string>
#include <vector>
#include <sstream>
#include <climits>

using namespace std;

string solution(string s) {
    stringstream ss(s);
    
    int num;
    int minVal = INT_MAX, maxVal = INT_MIN;

    while (ss >> num) {
        minVal = min(minVal, num);
        maxVal = max(maxVal, num);
    }

    return to_string(minVal) + " " + to_string(maxVal);
}