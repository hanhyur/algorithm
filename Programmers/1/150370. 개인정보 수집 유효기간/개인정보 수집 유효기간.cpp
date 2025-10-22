#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>

using namespace std;

int toDays(const string& date) {
    int y, m, d;
    char dot;
    stringstream ss(date);
    ss >> y >> dot >> m >> dot >> d;
    return y * 12 * 28 + m * 28 + d;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    int todayValue = toDays(today);
    
    unordered_map<string, int> termMap;
    vector<int> result;

    for (const string& term : terms)
    {
        string name;
        int months;
        stringstream ss(term);
        
        ss >> name >> months;
        
        termMap[name] = months * 28;
    }

    for (int i = 0; i < privacies.size(); i++)
    {
        string date, type;
        stringstream ss(privacies[i]);
        
        ss >> date >> type;

        int collected = toDays(date);
        int expire = collected + termMap[type] - 1;

        if (expire < todayValue)
        {
            result.push_back(i + 1);
        }
    }

    return result;
}