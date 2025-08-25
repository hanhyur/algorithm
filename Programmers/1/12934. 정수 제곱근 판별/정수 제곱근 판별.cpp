#include <string>
#include <vector>

using namespace std;

double m_pow(double n, double m) {
    double nn = n;
    
    if (m == 0)       
        return 1.0;
    
    for (int i = 0; i < (m - 1); i++)
        n *= nn;
    
    return n;
}

double m_sqrt(double n) {
    double s = n / 2;
    double t = 0;

    while (s != t) {
        t = s;
        s = ((n / t) + t) / 2;
    }
    
    return s;
}

long long solution(long long n) {
    long long answer = 0;
    
    if (m_pow((int) m_sqrt(n), 2) == n)
        return (long long) m_pow(m_sqrt(n) + 1, 2);
    
    return -1;
}