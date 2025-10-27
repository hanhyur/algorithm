#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    bool isStart = true;
    
    for (int i = 0; i < s.size(); i++)
    {
        char &c = s[i];
        
        if (isStart)
        {
            if (isalpha(c))
                c = toupper(c);
        } 
        else
        {
            if (isalpha(c))
                c = tolower(c);
        }
        
        isStart = (c == ' ');
    }
    
    return s;
}