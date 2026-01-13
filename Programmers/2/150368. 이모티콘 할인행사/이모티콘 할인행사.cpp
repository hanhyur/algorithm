#include <string>
#include <vector>

using namespace std;

const vector<int> DISCOUNTS = {10, 20, 30, 40};
int maxSubscribers = 0;
int maxRevenue = 0;

void simulate(const vector<int>& discounts,
             const vector<vector<int>>& users,
             const vector<int>& emoticons)
{
    int subscribers = 0;
    int revenue = 0;
    
    for (const auto& user : users)
    {
        int minDiscount = user[0];
        int maxPrice = user[1];
        int totalCost = 0;
        
        for (int i = 0; i < emoticons.size(); i++)
        {
            if (discounts[i] >= minDiscount)
            {
                totalCost += emoticons[i] * (100 - discounts[i]) / 100;
            }
        }
        
        if (totalCost >= maxPrice)
        {
            subscribers++;
        }
        else
        {
            revenue += totalCost;
        }
    }
    
    if (subscribers > maxSubscribers ||
       (subscribers == maxSubscribers && revenue > maxRevenue))
    {
        maxSubscribers = subscribers;
        maxRevenue = revenue;
    }
}

void dfs(int depth, vector<int>& discounts,
        const vector<vector<int>>& users,
        const vector<int>& emoticons)
{
    if (depth == emoticons.size())
    {
        simulate(discounts, users, emoticons);
        return;
    }
    
    for (int discount : DISCOUNTS)
    {
        discounts[depth] = discount;
        dfs(depth + 1, discounts, users, emoticons);
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> discounts(emoticons.size());
    
    dfs(0, discounts, users, emoticons);
    
    return {maxSubscribers, maxRevenue};
}