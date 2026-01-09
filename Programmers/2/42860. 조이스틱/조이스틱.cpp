#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(string name) {
    int length = name.size();
    int answer = 0;

    for (char c : name) {
        answer += min(c - 'A', 'Z' - c + 1);
    }

    int move = length - 1;

    for (int i = 0; i < length; i++) {
        int next = i + 1;

        while (next < length && name[next] == 'A') {
            next++;
        }

        int rightThenLeft = i * 2 + (length - next);
        int leftThenRight = (length - next) * 2 + i;

        move = min(move, min(rightThenLeft, leftThenRight));
    }

    return answer + move;
}