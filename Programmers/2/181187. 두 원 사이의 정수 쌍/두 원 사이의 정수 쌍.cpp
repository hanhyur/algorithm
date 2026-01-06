#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

static inline long long ceilSqrt(long long v)
{
    if (v <= 0)
        return 0;
    
    long long r = (long long) sqrt((long double) v);
    if (r * r < v)
        r++;
    
    return r;
}

long long solution(int r1, int r2)
{
    long long A = 0;

    long long r1Sq = 1LL * r1 * r1;
    long long r2Sq = 1LL * r2 * r2;

    for (int x = 1; x <= r2; x++)
    {
        long long xSq = 1LL * x * x;

        long long outerVal = r2Sq - xSq;
        if (outerVal < 0) 
            continue;
        long long outerY = (long long) sqrt((long double) outerVal);

        long long innerMinY = 1;
        long long innerVal = r1Sq - xSq;

        if (innerVal > 0)
        {
            long long y = ceilSqrt(innerVal);
            if (y > innerMinY)
                innerMinY = y;
        }

        if (outerY >= innerMinY)
        {
            A += (outerY - innerMinY + 1);
        }
    }

    long long axis = 4LL * (r2 - r1 + 1);

    return 4LL * A + axis;
}