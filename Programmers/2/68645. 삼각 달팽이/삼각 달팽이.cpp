#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<vector<int>> arr(n, vector<int>(n, 0));
    
    int dx[3] = {1, 0, -1};
    int dy[3] = {0, 1, -1};
    
    int x = 0, y = 0;
    int dir = 0;
    int num = 1;

    for (int len = n; len > 0; len--)
    {
        for (int i = 0; i < len; i++)
        {
            arr[x][y] = num++;

            if (i == len - 1) break;
            x += dx[dir];
            y += dy[dir];
        }

        dir = (dir + 1) % 3;
        x += dx[dir];
        y += dy[dir];
    }

    vector<int> result;
    for (int i = 0; i < n; i++)
        for (int j = 0; j <= i; j++)
            result.push_back(arr[i][j]);

    return result;
}