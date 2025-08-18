#include <string>
#include <vector>
#include <numeric>

using namespace std;

double solution(vector<int> arr) {
    int size = arr.size();
    
    return (double) accumulate(arr.begin(), arr.end(), 0) / size;
}