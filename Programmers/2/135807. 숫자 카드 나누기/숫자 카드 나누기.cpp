#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool isValid(int value, const vector<int>& target)
{
    for (int num : target)
        if (num % value == 0)
            return false;
    
    return true;
}

int gcd(int a, int b)
{
    while (b != 0)
    {
        int tmp = a % b;
        a = b;
        b = tmp;
    }
    
    return a;
}

int calculate(const vector<int>& arr)
{
    int result = arr[0];
    
    for (int i = 1; i < arr.size(); i++)
        result = gcd(result, arr[i]);
    
    return result;
}

int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0;
    
    int gcdA = calculate(arrayA);
    int gcdB = calculate(arrayB);
    
    if (isValid(gcdA, arrayB))
        answer = gcdA;
    
    if (isValid(gcdB, arrayA))
        answer = max(answer, gcdB);
    
    return answer;
}