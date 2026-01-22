class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        for (auto& num : nums)
            mp[num]++;

        vector<pair<int, int>> frequencies;
        for (auto& i : mp)
            frequencies.push_back({i.first, i.second});

        vector<vector<int>> bucket(nums.size() + 1);
        for (auto& freq : frequencies) {
            bucket[freq.second].push_back(freq.first);
        }
        vector<int> ans(k);
        k--;
        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (int j = bucket[i].size() - 1; j >= 0; j--) {
                ans[k] = bucket[i][j];
                k--;
                if (k < 0)
                    return ans;
            }
        }
        return ans;
    }
};
