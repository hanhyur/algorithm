#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_set<int> st;

bool isPrime(int n)
{
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    
    for (int i = 3; i <= sqrt(n); i += 2)
        if (n % i == 0) return false;
    
    return true;
}

void dfs(const string& numbers, string cur, bool visited[])
{
    if (!cur.empty()) st.insert(stoi(cur));
    
    for (int i = 0; i < numbers.size(); i++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            dfs(numbers, cur + numbers[i], visited);
            visited[i] = false;
        }
    }
}

int solution(string numbers) {
    bool visited[7] = {false};
    dfs(numbers, "", visited);
    
    int answer = 0;
    
    for (int n : st)
        if (isPrime(n))
            answer++;
    
    return answer;
}