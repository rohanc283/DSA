class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
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
};