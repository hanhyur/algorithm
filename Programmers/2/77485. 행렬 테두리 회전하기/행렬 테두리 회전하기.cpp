#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<vector<int>> board(rows, vector<int>(columns));
    int value = 1;
    for (int i = 0; i < rows; ++i)
    {
        for (int j = 0; j < columns; ++j)
        {
            board[i][j] = value++;
        }
    }

    vector<int> answer;
    answer.reserve(queries.size());

    auto rotateBorder = [&](int x1, int y1, int x2, int y2)
    {
        int temp = board[x1][y1];
        int minVal = temp;

        for (int x = x1; x < x2; ++x)
        {
            board[x][y1] = board[x + 1][y1];
            minVal = min(minVal, board[x][y1]);
        }

        for (int y = y1; y < y2; ++y)
        {
            board[x2][y] = board[x2][y + 1];
            minVal = min(minVal, board[x2][y]);
        }

        for (int x = x2; x > x1; --x)
        {
            board[x][y2] = board[x - 1][y2];
            minVal = min(minVal, board[x][y2]);
        }

        for (int y = y2; y > y1 + 1; --y)
        {
            board[x1][y] = board[x1][y - 1];
            minVal = min(minVal, board[x1][y]);
        }

        board[x1][y1 + 1] = temp;
        minVal = min(minVal, temp);

        return minVal;
    };
    
    for (auto &q : queries)
    {
        int x1 = q[0] - 1;
        int y1 = q[1] - 1;
        int x2 = q[2] - 1;
        int y2 = q[3] - 1;

        int minVal = rotateBorder(x1, y1, x2, y2);
        answer.push_back(minVal);
    }

    return answer;
}