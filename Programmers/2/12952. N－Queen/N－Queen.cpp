#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

void dfs(int cols, int diag1, int diag2, int mask, int &count)
{
    if (cols == mask)
    {
        ++count;
        return;
    }
    
    int available = (~(cols | diag1 | diag2)) & mask;
    
    while (available)
    {
        int bit = available & - available;
        available -= bit;
        
        dfs(cols | bit,
           (diag1 | bit) << 1,
           (diag2 | bit) >> 1,
           mask,
           count);
    }
}

int solution(int n) {
    const int mask = (1 << n) - 1;
    int count = 0;
    
    dfs(0, 0, 0, mask, count);
    return count;
}