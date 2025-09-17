#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    int temp = 1;
    int mul = n * m;
        
    while (temp != 0) {
        temp = m % n;
        m = n;
        n = temp;
    }
    
    answer.push_back(m);
    answer.push_back(mul / m);
    
    return answer;
}