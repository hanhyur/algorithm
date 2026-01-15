#include <string>
#include <vector>

using namespace std;

static int maxDiff = 0;
static vector<int> bestResult;

int calculateScore(const vector<int>& ryan, const vector<int>& info) {
    int ryanScore = 0;
    int apeachScore = 0;

    for (int i = 0; i < 11; i++) {
        int score = 10 - i;

        if (ryan[i] > info[i]) {
            ryanScore += score;
        } else if (info[i] > 0) {
            apeachScore += score;
        }
    }

    return (ryanScore > apeachScore) ? (ryanScore - apeachScore) : 0;
}

bool isBetter(const vector<int>& ryan) {
    for (int i = 10; i >= 0; i--) {
        if (ryan[i] > bestResult[i]) return true;
        if (ryan[i] < bestResult[i]) return false;
    }
    return false;
}

void dfs(int index, int remain, vector<int>& ryan, const vector<int>& info) {
    if (index == 11) {

        if (remain > 0) {
            ryan[10] += remain;
        }

        int diff = calculateScore(ryan, info);

        if (diff > maxDiff || (diff == maxDiff && !bestResult.empty() && isBetter(ryan))) {
            maxDiff = diff;
            bestResult = ryan;
        }

        if (remain > 0) {
            ryan[10] -= remain;
        }
        return;
    }

    int need = info[index] + 1;
    if (remain >= need) {
        ryan[index] = need;
        dfs(index + 1, remain - need, ryan, info);
        ryan[index] = 0;
    }

    dfs(index + 1, remain, ryan, info);
}

vector<int> solution(int n, vector<int> info) {
    vector<int> ryan(11, 0);
    maxDiff = 0;
    bestResult.clear();

    dfs(0, n, ryan, info);

    if (bestResult.empty()) {
        return {-1};
    }

    return bestResult;
}