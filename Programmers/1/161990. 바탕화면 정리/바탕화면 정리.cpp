#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    int rows = (int)wallpaper.size();
    int cols = (int)wallpaper[0].size();

    int minR = rows, minC = cols;
    int maxR = -1,  maxC = -1;

    for (int r = 0; r < rows; ++r) {
        const string& line = wallpaper[r];
        for (int c = 0; c < cols; ++c) {
            if (line[c] == '#') {
                minR = min(minR, r);
                minC = min(minC, c);
                maxR = max(maxR, r);
                maxC = max(maxC, c);
            }
        }
    }

    return { minR, minC, maxR + 1, maxC + 1 };
}