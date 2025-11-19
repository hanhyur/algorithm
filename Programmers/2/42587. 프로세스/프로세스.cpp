#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Process {
    int priority;
    int index;
};

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<Process> q;
    
    for (int i = 0; i < priorities.size(); i++)
    {
        q.push({priorities[i], i});
    }
    
    while (!q.empty())
    {
        Process cur = q.front();
        q.pop();
        
        int maxPriority = 0;
        queue<Process> tmp = q;
        
        while (!tmp.empty())
        {
            maxPriority = max(maxPriority, tmp.front().priority);
            tmp.pop();
        }
        
        if (cur.priority < maxPriority)
        {
            q.push(cur);
        }
        else
        {
            answer++;
            
            if (cur.index == location)
                return answer;
        }
    }
    
    return -1;
}