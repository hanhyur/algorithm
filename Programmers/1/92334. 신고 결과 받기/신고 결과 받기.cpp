#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    
    unordered_set<string> unique(report.begin(), report.end());

    unordered_map<string, int> idIndex;
    
    for (int i = 0; i < (int)id_list.size(); ++i)
        idIndex[id_list[i]] = i;

    unordered_map<string, unordered_set<string>> reportedMap;

    for (const string& r : unique)
    {
        auto pos = r.find(' ');
        
        string reporter = r.substr(0, pos);
        string target = r.substr(pos + 1);
        
        reportedMap[target].insert(reporter);
    }
    
    for (auto& [target, reporters] : reportedMap)
    {
        if (reporters.size() >= k)
        {
            for (auto& reporter : reporters)
            {
                answer[idIndex[reporter]]++;
            }
        }
    }
    
    return answer;
}