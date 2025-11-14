#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int result = 1;
    unordered_map<string, int> mp;

    for (auto &c : clothes) {
        mp[c[1]]++;
    }

    for (auto &p : mp) {
        result *= (p.second + 1);
    }

    return result - 1;
}