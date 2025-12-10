#include <string>
#include <vector>

using namespace std;

vector<vector<int>> rotate(vector<vector<int>>& key)
{
    int M = key.size();
    vector<vector<int>> ret(M, vector<int>(M, 0));
    
    for (int i = 0; i < M; i++)
        for (int j = 0; j < M; j++)
            ret[j][M - 1 - i] = key[i][j];
    
    return ret;
}

bool check(const vector<vector<int>>& board,
          const vector<vector<int>>& key,
          int sx, int sy, int N, int M)
{
    vector<vector<int>> temp = board;
    
    for (int i = 0; i < M; i++)
        for (int j = 0; j < M; j++)
            temp[sx + i][sy + j] += key[i][j];
    
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            if (temp[i + M - 1][j + M - 1] != 1)
                return false;
    
    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int M = key.size();
    int N = lock.size();
    int size = N + 2 * (M - 1);
    
    vector<vector<int>> board(size, vector<int>(size, 0));
    
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            board[i + M - 1][j + M - 1] = lock[i][j];
    
    for (int r = 0; r < 4; r++)
    {
        key = rotate(key);
        
        for (int x = 0; x <= size - M; x++)
        {
            for (int y = 0; y <= size - M; y++)
            {
                if (check(board, key, x, y, N, M))
                    return true;
            }
        }
    }
    
    return false;
}