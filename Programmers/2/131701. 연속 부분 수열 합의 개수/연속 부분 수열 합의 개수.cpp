#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> elements) {
    int n = elements.size();
    
    vector<int> extended(2 * n);
    for (int i = 0; i < 2 * n; i++)
        extended[i] = elements[i % n];
    
    unordered_set<int> sumSet;

    vector<int> prefix(2 * n + 1, 0);
    for (int i = 1; i <= 2 * n; i++)
        prefix[i] = prefix[i - 1] + extended[i - 1];

    for (int len = 1; len <= n; len++)
    {
        for (int start = 0; start < n; start++)
        {
            int sum = prefix[start + len] - prefix[start];
            sumSet.insert(sum);
        }
    }

    return sumSet.size();
}