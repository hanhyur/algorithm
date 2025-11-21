#include <string>
#include <vector>

using namespace std;

int dfs(const vector<int>& numbers, int target, int depth, int sum) {
    if (depth == numbers.size()) {
        return sum == target ? 1 : 0;
    }

    return dfs(numbers, target, depth + 1, sum + numbers[depth]) + 
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
}

int solution(vector<int> numbers, int target) {
    return dfs(numbers, target, 0, 0);
}