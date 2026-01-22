class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        for (auto& num : nums)
            mp[num]++;

        vector<vector<int>> bucket(nums.size() + 1);
        for (auto& i : mp)
            bucket[i.second].push_back(i.first);

        vector<int> ans;
        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (int j = bucket[i].size() - 1; j >= 0; j--) {
                ans.push_back(bucket[i][j]);
                if (ans.size() == k)
                    return ans;
            }
        }
        return ans;
    }
};
