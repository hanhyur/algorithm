#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> stack;
    stack.reserve(ingredient.size());

    for (int x : ingredient) {
        stack.push_back(x);
        int n = stack.size();

        if (n >= 4 &&
            stack[n - 4] == 1 &&
            stack[n - 3] == 2 &&
            stack[n - 2] == 3 &&
            stack[n - 1] == 1) {
            stack.resize(n - 4);
            answer++;
        }
    }

    return answer;
}