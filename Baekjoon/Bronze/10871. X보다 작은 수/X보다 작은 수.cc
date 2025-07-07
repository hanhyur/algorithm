#include <iostream>
int main(void){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);
    
    int n, x;
    
    std::cin >> n >> x;
    
    int* a = new int[n];
    
    for (int i = 0; i < n; i++) {
        std::cin >> a[i];
    }
    
    for (int i = 0; i < n; i++) {
        if (a[i] < x) {
            std::cout << a[i] << ' ';
        }
    }
    
    delete[] a;
}