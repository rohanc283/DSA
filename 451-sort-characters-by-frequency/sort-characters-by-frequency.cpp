class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> freq;
        for (auto& c : s) {
            freq[c]++;
        }
        vector<vector<char>> bucket(s.size() + 1);
        for (auto& i : freq) {
            bucket[i.second].push_back(i.first);
        }

        int k = 0;
        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (int j = 0; j < bucket[i].size(); j++) {
                for (int l = i; l > 0; l--) {
                    s[k++] = bucket[i][j];
                }
            }
        }
        return s;
    }
};