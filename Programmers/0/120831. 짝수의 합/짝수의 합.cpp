#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    while (n > 0) {
        if (n % 2 == 0) {
            answer += n;
        }
        
        n--;
    }
    
    return answer;
}