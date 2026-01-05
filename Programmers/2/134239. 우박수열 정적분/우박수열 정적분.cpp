#include <string>
#include <vector>

using namespace std;

vector<double> solution(int k, vector<vector<int>> ranges) {
    vector<long long> sequence;
    sequence.push_back(k);

    while (k != 1)
    {
        if (k % 2 == 0)
            k /= 2;
        else
            k = k * 3 + 1;
            
        sequence.push_back(k);
    }

    int n = sequence.size() - 1;

    vector<double> area(n);
    for (int i = 0; i < n; i++)
    {
        area[i] = (sequence[i] + sequence[i + 1]) / 2.0;
    }

    vector<double> prefix(n + 1, 0.0);
    for (int i = 0; i < n; i++)
    {
        prefix[i + 1] = prefix[i] + area[i];
    }

    vector<double> answer;
    for (auto& r : ranges)
    {
        int start = r[0];
        int end = n + r[1];

        if (start > end)
        {
            answer.push_back(-1);
        } 
        else
        {
            answer.push_back(prefix[end] - prefix[start]);
        }
    }

    return answer;
}