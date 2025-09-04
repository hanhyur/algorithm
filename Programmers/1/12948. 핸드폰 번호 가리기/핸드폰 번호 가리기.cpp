#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    vector<char> vec(phone_number.begin(), phone_number.end());
    
    for (int i = 0; i < vec.size() - 4; i++) {
        vec[i] = '*';
    }
    
    string answer(vec.begin(), vec.end());
    
    return answer;
}