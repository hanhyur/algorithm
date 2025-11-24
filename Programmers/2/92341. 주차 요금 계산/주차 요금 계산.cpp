#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int timeToInt(const string& time) {
    int h = stoi(time.substr(0, 2));
    int m = stoi(time.substr(3, 2));
    
    return h * 60 + m;
}

int calcFee(int total, const vector<int>& f) {
    if (total <= f[0]) return f[1];
    
    int extra = total - f[0];
    int units = (extra + f[2] - 1) / f[2];
    
    return f[1] + units * f[3];
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    
    map<string, int> total;
    unordered_map<string, int> inMap;
    
    for (const string& record : records)
    {
        stringstream ss(record);
        string timeStr, car, type;
        ss >> timeStr >> car >> type;

        int time = timeToInt(timeStr);

        if (type == "IN")
        {
            inMap[car] = time;
        } 
        else
        {
            int inTime = inMap[car];
            inMap.erase(car);
            total[car] += (time - inTime);
        }
    }

    int end = 23 * 60 + 59;

    for (auto& p : inMap)
    {
        string car = p.first;
        int inTime = p.second;
        total[car] += (end - inTime);
    }

    answer.reserve(total.size());

    for (auto& p : total)
    {
        int cost = calcFee(p.second, fees);
        answer.push_back(cost);
    }
    
    return answer;
}