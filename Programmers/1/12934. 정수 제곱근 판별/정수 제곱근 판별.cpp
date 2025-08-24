#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    if (pow((long double) sqrt(n), 2) == n) {
        return (long long) pow(sqrt(n) + 1, 2);
    }
    
    return -1;
}