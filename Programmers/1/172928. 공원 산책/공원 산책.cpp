#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    int y = 0, x = 0, h = park.size(), w = park[0].size();
    
    for (int i = 0; i < h; i++)
    {
        if ((x = park[i].find('S')) != string::npos)
        {
            y = i;
            break;
        }
    }
    
    map<char, pair<int,int>> d = {{'N', {-1, 0}}, {'S', {1, 0}}, {'W', {0, -1}}, {'E', {0, 1}}};
    
    for (auto& r : routes)
    {
        char c;
        int n;
        stringstream ss(r);
        ss >> c >> n;
        
        int ny = y, nx = x; 
        bool ok = true;
        
        for (int i = 0; i < n; i++)
        {
            ny += d[c].first;
            nx += d[c].second;
            
            if (ny < 0 || nx < 0 || ny >= h || nx >= w ||
                park[ny][nx] =='X')
            {
                ok = false;
                break;
            }
        }
        
        if (ok)
        {
            y = ny;
            x = nx;
        }
    }
    
    return {y, x};
}