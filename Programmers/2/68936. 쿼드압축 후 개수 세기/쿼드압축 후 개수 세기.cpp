#include <string>
#include <vector>

using namespace std;

int zeroCount = 0;
int oneCount = 0;

bool isUniform(const vector<vector<int>>& arr, int x, int y, int size) {
    int value = arr[x][y];
    
    for (int i = x; i < x + size; ++i)
    {
        for (int j = y; j < y + size; ++j)
        {
            if (arr[i][j] != value)
            {
                return false;
            }
        }
    }
    
    return true;
}

void compress(const vector<vector<int>>& arr, int x, int y, int size) {
    if (isUniform(arr, x, y, size))
    {
        int value = arr[x][y];
        
        if (value == 0)
        {
            zeroCount++;
        } 
        else 
        {
            oneCount++;
        }
        
        return;
    }

    int half = size / 2;
    compress(arr, x, y, half);
    compress(arr, x, y + half, half);
    compress(arr, x + half, y, half);
    compress(arr, x + half, y + half, half);
}

vector<int> solution(vector<vector<int>> arr) {
    int n = static_cast<int>(arr.size());
    zeroCount = 0;
    oneCount = 0;
    
    compress(arr, 0, 0, n);
    
    return {zeroCount, oneCount};
}