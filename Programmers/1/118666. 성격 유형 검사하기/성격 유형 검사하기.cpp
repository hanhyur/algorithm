#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    unordered_map<char, int> scoreMap;

    string types = "RTCFJMAN";
    
    for (char c : types) {
        scoreMap[c] = 0;
    }

    for (int i = 0; i < survey.size(); i++) {
        char disagree = survey[i][0];
        char agree = survey[i][1];
        int choice = choices[i];

        if (choice < 4) {
            scoreMap[disagree] += 4 - choice;
        } else if (choice > 4) {
            scoreMap[agree] += choice - 4;
        }
    }

    answer += (scoreMap['R'] >= scoreMap['T']) ? 'R' : 'T';
    answer += (scoreMap['C'] >= scoreMap['F']) ? 'C' : 'F';
    answer += (scoreMap['J'] >= scoreMap['M']) ? 'J' : 'M';
    answer += (scoreMap['A'] >= scoreMap['N']) ? 'A' : 'N';
    
    return answer;
}