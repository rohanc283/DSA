class Solution {
public:
    long long ans = 0;
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
    void mergeSort(vector<int>& nums, int l, int r, int diff) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m, diff);
        mergeSort(nums, m + 1, r, diff);
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j] + diff) {
                ans += (r - j + 1);
                i++;
            } else {
                j++;
            }
        }
        merge(nums, l, m, r);
    }
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        int n = nums1.size();
        vector<int> nums(n);
        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }
        mergeSort(nums, 0, n - 1, diff);
        return ans;
    }
};