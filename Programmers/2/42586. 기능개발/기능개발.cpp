#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    
    for (int i = 0; i < progresses.size(); i++)
    {
        int remain = 100 - progresses[i];
        int days = (remain + speeds[i]  - 1) / speeds[i];
        
        q.push(days);
    }
    
    while (!q.empty())
    {
        int releaseDay = q.front();
        q.pop();
        int count = 1;
        
        while (!q.empty() && q.front() <= releaseDay)
        {
            q.pop();
            count++;
        }
        
        answer.push_back(count);
    }
    
    return answer;
}