#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    int p1 = 0;
    int p2 = 0;
    
    for (string str : goal) {
        if (p1 < cards1.size() && str == cards1[p1])
        {
            p1++;
            continue;
        } 
        
        if (p2 < cards2.size() && str == cards2[p2])
        {
            p2++;
            continue;
        }
        
        return "No";
    }
    
    return "Yes";
}