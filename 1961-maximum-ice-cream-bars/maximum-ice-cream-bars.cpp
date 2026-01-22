class Solution {
public:
    int sol1(vector<int>& costs, int coins) {
        map<int, int> mp;
        for (auto& cost : costs)
            mp[cost]++;

        int ans = 0;
        for (auto& i : mp) {
            while (i.second--) {
                if (coins < i.first)
                    break;
                ans++;
                coins -= i.first;
            }
        }
        return ans;
    }
    int sol2(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        int ans = 0;
        for (auto& cost : costs) {
            if (coins < cost)
                break;
            coins -= cost;
            ans++;
        }
        return ans;
    }
    int sol3(vector<int>& costs, int coins) {
        vector<int> mp(100001, 0);
        for (auto& cost : costs)
            mp[cost]++;

        int ans = 0;
        for (int i = 0; i < mp.size(); i++) {
            while (mp[i]--) {
                if (coins < i)
                    break;
                ans++;
                coins -= i;
            }
        }
        return ans;
    }
    int maxIceCream(vector<int>& costs, int coins) {
        return sol3(costs, coins);
    }
};