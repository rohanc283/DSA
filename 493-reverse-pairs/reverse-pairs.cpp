class Solution {
public:
    int ans = 0;
    void merge(vector<int>& nums, int l, int m, int r) {
        int i = l, j = m + 1;
        vector<int> temp;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp.push_back(nums[i++]);
            } else {
                temp.push_back(nums[j++]);
            }
        }
        while (i <= m) {
            temp.push_back(nums[i++]);
        }
        while (j <= r) {
            temp.push_back(nums[j++]);
        }
        for (int k = 0; k < temp.size(); k++)
            nums[k + l] = temp[k];
    }
    void mergeSort(vector<int>& nums, int l, int r) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (nums[i] > nums[j] * 2LL) {
                ans += (m - i + 1);
                j++;
            } else {
                i++;
            }
        }
        merge(nums, l, m, r);
    }
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        mergeSort(nums, 0, n - 1);
        // for (int s = 1; s < n; s++) {
        //     for (int l = 0; l < n; l += 2 * s) {
        //         int r = min(n - 1, l + 2 * s - 1);
        //         int m = min(n - 1, l + s - 1);
        //         if (m < r) {
        //             merge(nums, l, m, r, ans);
        //         }
        //     }
        // }
        return ans;
    }
};