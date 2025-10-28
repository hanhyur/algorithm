#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    int transformCount = 0;
    int removedZeroCount = 0;

    while (s != "1")
    {
        int zeros = 0;
        
        for (char c : s)
        {
            if (c == '0') zeros++;
        }
        removedZeroCount += zeros;

        int ones = s.size() - zeros;
        
        string binary = "";
        
        while (ones > 0)
        {
            binary = char('0' + (ones % 2)) + binary;
            ones /= 2;
        }

        s = binary;
        transformCount++;
    }

    return {transformCount, removedZeroCount};
}