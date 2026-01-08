#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Task
{
    string name;
    int start;
    int remaining;
};

static int toMinutes(const string& hhmm)
{
    int hh = stoi(hhmm.substr(0, 2));
    int mm = stoi(hhmm.substr(3, 2));
    
    return hh * 60 + mm;
}

vector<string> solution(vector<vector<string>> plans)
{
    int n = (int)plans.size();
    vector<Task> arr;
    arr.reserve(n);

    for (auto &p : plans)
    {
        Task t;
        t.name = p[0];
        t.start = toMinutes(p[1]);
        t.remaining = stoi(p[2]);
        arr.push_back(t);
    }

    sort(arr.begin(), arr.end(), [](const Task& a, const Task& b) {
        return a.start < b.start;
    });

    vector<string> done;
    done.reserve(n);

    vector<Task> st;

    for (int i = 0; i < n; i++)
    {
        Task cur = arr[i];
        int curTime = cur.start;
        int nextStart = (i == n - 1) ? INT_MAX : arr[i + 1].start;

        int available = nextStart - curTime;

        if (cur.remaining <= available)
        {
            curTime += cur.remaining;
            done.push_back(cur.name);
            available -= cur.remaining;

            while (available > 0 && !st.empty())
            {
                Task &top = st.back();
                
                if (top.remaining <= available)
                {
                    available -= top.remaining;
                    done.push_back(top.name);
                    st.pop_back();
                } 
                else
                {
                    top.remaining -= available;
                    available = 0;
                }
            }
        } 
        else
        {
            cur.remaining -= available;
            st.push_back(cur);
        }
    }

    while (!st.empty())
    {
        done.push_back(st.back().name);
        st.pop_back();
    }

    return done;
}