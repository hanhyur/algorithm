#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    int n = arr1.size();
    int m = arr2[0].size();
    int k = arr1[0].size();

    vector<vector<int>> result(n, vector<int>(m, 0));

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < m; ++j)
        {
            for (int x = 0; x < k; ++x)
            {
                result[i][j] += arr1[i][x] * arr2[x][j];
            }
        }
    }
    
    return result;
}