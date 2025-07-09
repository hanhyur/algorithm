#include <bits/stdc++.h>
using namespace std;

int arr[10];
int a, b, c;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> a >> b >> c;
    
    int multiply = a * b * c;
    
    while (multiply) {
        arr[multiply % 10]++;
        multiply /= 10;
    }
    
    for (int i = 0; i < 10; i++)
        cout << arr[i] << '\n';
}
