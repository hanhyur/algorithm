#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int count = 0;
    
    if (s.length() % 2 == 0) {
        count = 2;
    } else {
        count = 1;
    }
    
    return s.substr((s.length() - 1) / 2, count);
}