class Solution {
public:
    void merge(vector<int>& arr, int l, int mid, int r) {
        int i = l, n1 = mid, j = mid + 1, n2 = r;
        vector<int> temp;
        while (i <= n1 || j <= n2) {
            if (i <= n1 && j > n2) {
                temp.push_back(arr[i++]);
            } else if (i > n1 && j <= n2) {
                temp.push_back(arr[j++]);
            } else if (arr[i] < arr[j]) {
                temp.push_back(arr[i++]);
            } else {
                temp.push_back(arr[j++]);
            }
        }
        for (int k = 0; k < temp.size(); k++) {
            arr[k + l] = temp[k];
        }
    }

    vector<int> sortArray(vector<int>& nums) {
        int n = nums.size();
        for (int size = 1; size <= n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int right = min(n - 1, left + 2 * size - 1);
                int mid = left + size - 1;
                merge(nums, left, mid, right);
            }
        }
        return nums;
    }
};