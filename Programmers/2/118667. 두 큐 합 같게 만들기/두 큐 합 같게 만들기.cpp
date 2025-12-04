#include <string>
#include <vector>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum1 = 0, sum2 = 0;
    int n = queue1.size();
    
    for (long long x : queue1) sum1 += x;
    for (long long y : queue2) sum2 += y;
    
    long long total = sum1 + sum2;
    if (total % 2 != 0) return -1;
    
    long long target  = total / 2;
    
    vector<long long> arr(2 * n);
    for (int i = 0; i < n; i++) arr[i] = queue1[i];
    for (int j = 0; j < n; j++) arr[n + j] = queue2[j];
    
    int left = 0, right = n;
    long long cur = sum1;
    
    int limit = n * 3;
    int ops = 0;
    
    while (ops <= limit)
    {
        if (cur == target) return ops;
        
        if (cur < target)
        {
            cur += arr[right++];
        }
        else
        {
            cur -= arr[left++];
        }
        
        ops++;
    }
    
    return -1;
}