class Solution {
public:
    vector<int> ans;
    void merge(vector<pair<int, int>>& arr, int l, int m, int r) {
        int i = l, j = m + 1;
        vector<pair<int, int>> temp;
        int rightSmallerCount = 0;
        while (i <= m && j <= r) {
            if (arr[i].first <= arr[j].first) {
                ans[arr[i].second] += rightSmallerCount;
                temp.push_back(arr[i++]);
            } else {
                temp.push_back(arr[j++]);
                rightSmallerCount++;
            }
        }

        while (i <= m) {
            ans[arr[i].second] += rightSmallerCount;
            temp.push_back(arr[i++]);
        }

        while (j <= r) {
            temp.push_back(arr[j++]);
        }

        for (int k = 0; k < temp.size(); k++) {
            arr[l + k] = temp[k];
        }
    }
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        ans.assign(n, 0);
        vector<pair<int, int>> pairArr;
        for (int i = 0; i < n; i++) {
            pairArr.push_back({nums[i], i});
        }
        for (int s = 1; s <= n; s *= 2) {
            for (int l = 0; l < n; l += 2 * s) {
                int r = min(n - 1, l + 2 * s - 1);
                int m = min(n - 1, l + s - 1);
                if (m < r) {
                    merge(pairArr, l, m, r);
                }
            }
        }
        return ans;
    }
};