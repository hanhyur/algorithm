#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    priority_queue<int> pq;

    for (int i = 0; i < (int)enemy.size(); i++)
    {
        n -= enemy[i];
        pq.push(enemy[i]);

        if (n < 0)
        {
            if (k <= 0)
                return i;
            
            int largest = pq.top(); pq.pop();
            n += largest;
            k--;
            
            if (n < 0)
                return i;
        }
    }
    
    return (int) enemy.size();
}