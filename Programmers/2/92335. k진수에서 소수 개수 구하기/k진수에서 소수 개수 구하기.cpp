#include <string>
#include <vector>
#include <cmath>

using namespace std;

string toStr(long long n,int k)
{
    string result = "";
    
    while (n > 0)
    {
        result = char('0' + (n % k)) + result;
        n /= k;
    }
    
    return result;
}

bool isPrime(long long num)
{
    if (num < 2) return false;
    
    for (long long i = 2; i * i <= num; i++)
    {
        if (num % i == 0) return false;
    }
    
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    
    string str = toStr(n, k);
    
    vector<long long> nums;
    string cur = "";
    
    for (char c : str)
    {
        if (c == '0')
        {
            if (!cur.empty())
            {
                nums.push_back(stoll(cur));
                cur.clear();
            }
        }
        else
        {
            cur.push_back(c);
        }
    }
    
    if (!cur.empty()) nums.push_back(stoll(cur));
    
    for (long long num : nums)
    {
        if (isPrime(num)) answer++;
    }
    
    return answer;
}