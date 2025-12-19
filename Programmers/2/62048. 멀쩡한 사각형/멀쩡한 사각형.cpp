#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b)
{
    while (b != 0)
    {
        long long r = a % b;
        a = b;
        b = r;
    }
    
    return a;
}

long long solution(int w,int h) {
    long long W = w;
    long long H = h;
    long long answer = W * H;
    
    long long G = gcd(W, H);
    long long broken = W + H - G;
    
    return answer - broken;
}