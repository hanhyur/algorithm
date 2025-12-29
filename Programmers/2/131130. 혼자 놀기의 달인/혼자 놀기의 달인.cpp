#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> cards) {
    int n = cards.size();
    vector<bool> visited(n, false);
    vector<int> cycleSizes;

    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;

        int current = i;
        int count = 0;

        while (!visited[current]) {
            visited[current] = true;
            current = cards[current] - 1;
            count++;
        }

        cycleSizes.push_back(count);
    }

    if (cycleSizes.size() < 2) return 0;

    sort(cycleSizes.begin(), cycleSizes.end(), greater<int>());

    return cycleSizes[0] * cycleSizes[1];
}