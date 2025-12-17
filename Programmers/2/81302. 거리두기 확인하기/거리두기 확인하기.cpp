#include <string>
#include <vector>

using namespace std;

bool inRange(int x, int y) {
    return x >= 0 && y >= 0 && x < 5 && y < 5;
}

bool isViolation(const vector<string>& map, int x, int y)
{
    int direct1[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    int direct2[4][2] = {{2,0},{-2,0},{0,2},{0,-2}};
    int diagonal[4][2] = {{1,1},{1,-1},{-1,1},{-1,-1}};

    for (auto& d : direct1)
    {
        int nx = x + d[0];
        int ny = y + d[1];
        if (inRange(nx, ny) && map[nx][ny] == 'P')
        {
            return true;
        }
    }

    for (auto& d : direct2)
    {
        int nx = x + d[0];
        int ny = y + d[1];
        int mx = x + d[0] / 2;
        int my = y + d[1] / 2;

        if (inRange(nx, ny) && map[nx][ny] == 'P' && map[mx][my] != 'X')
        {
            return true;
        }
    }

    for (auto& d : diagonal)
    {
        int nx = x + d[0];
        int ny = y + d[1];

        if (inRange(nx, ny) && map[nx][ny] == 'P')
        {
            if (map[x][ny] != 'X' || map[nx][y] != 'X')
            {
                return true;
            }
        }
    }

    return false;
}

bool isValidPlace(const vector<string>& place)
{
    for (int x = 0; x < 5; x++)
    {
        for (int y = 0; y < 5; y++)
        {
            if (place[x][y] == 'P')
            {
                if (isViolation(place, x, y))
                {
                    return false;
                }
            }
        }
    }
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;

    for (auto& place : places)
    {
        answer.push_back(isValidPlace(place) ? 1 : 0);
    }

    return answer;
}