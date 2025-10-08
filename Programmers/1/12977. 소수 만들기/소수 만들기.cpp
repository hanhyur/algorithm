#include <vector>
#include <iostream>
#include <math.h>

using namespace std;

int isPrime(int n)
{
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (!(n % i))
            return 0;
    }
    
    return 1;
}

int solution(vector<int> nums) {
    int answer = 0;

    for (int i = 0; i < nums.size() - 2; i++)
    {
        for(int j = i + 1; j < nums.size() - 1; j++)
        {
            for(int k = j + 1; k < nums.size(); k++)
            {
                answer += isPrime(nums[i] + nums[j] + nums[k]);
            }
        }
    }

    return answer;
}