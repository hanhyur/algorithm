#include<bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    for (char ch = 'a'; ch <= 'z'; ch++) {
        int cnt = 0;
        for (auto c : s)
            if (ch == c) cnt++;
        cout << cnt << ' ';
    }
}