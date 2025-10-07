#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v1 = {1, 2, 3, 4, 5};
vector<int> v2 = {2, 1, 2, 3, 2, 4, 2, 5};
vector<int> v3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> trio(3);
    
    for (int i = 0; i < answers.size(); i++) 
    {
        if(answers[i] == v1[i % v1.size()]) 
            trio[0]++;
        
        if(answers[i] == v2[i % v2.size()]) 
            trio[1]++;
        
        if(answers[i] == v3[i % v3.size()]) 
            trio[2]++;
    }
    
    int trio_max = *max_element(trio.begin(), trio.end());
    
    for (int i = 0; i < 3; i++)
    {
        if(trio[i] == trio_max)
            answer.push_back(i + 1);
    }    
    
    return answer;
}