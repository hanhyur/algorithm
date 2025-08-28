#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long sumAtoB(long long min, long long max) {
    return (max - min + 1) * (min + max) / 2;
}

long long solution(int a, int b) {
    return sumAtoB(min(a, b), max(a, b));
}