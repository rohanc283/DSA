class Solution {
public:
    int minSetSize(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, int> mp;
        for (auto& i : arr)
            mp[i]++;

        vector<int> counts;
        for (auto& i : mp) {
            counts.push_back(i.second);
        }
        sort(counts.begin(), counts.end());
        int c = n, ans = 0;
        for (int i = counts.size() - 1; i >= 0; i--) {
            c -= counts[i];
            ans++;
            if (c <= n / 2)
                break;
        }
        return ans;
    }
};