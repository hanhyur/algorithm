#include <iostream>
#include <string>

using namespace std;

int main(void) {
    int a;
    int b;
    cin >> a >> b;
    
    string s;
    
    s.append(a, '*');
    
    for (int i = 0; i < b; i++) {
        cout << s << '\n';
    }
    
    return 0;
}