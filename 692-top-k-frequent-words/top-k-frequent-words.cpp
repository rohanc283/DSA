class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> mp;
        for (auto& word : words)
            mp[word]++;

        vector<vector<string>> bucket(words.size() + 1);
        for (auto& i : mp)
            bucket[i.second].push_back(i.first);

        vector<string> ans;
        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (bucket[i].size() > 1) {
                sort(bucket[i].begin(), bucket[i].end());
            }
            for (int j = 0; j < bucket[i].size(); j++) {
                ans.push_back(bucket[i][j]);
                if (ans.size() == k)
                    return ans;
            }
        }
        return ans;
    }
};