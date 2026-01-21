class Solution {
public:
    vector<int> ans;

    void merge(vector<pair<int, int>>& arr, int l, int mid, int r) {
        int i = l, j = mid + 1;
        vector<pair<int, int>> temp;
        int rightCount = 0;
        while (i <= mid && j <= r) {
            if (arr[j].first < arr[i].first) {
                // right element is smaller
                temp.push_back(arr[j]);
                rightCount++;
                j++;
            } else {
                // left element is placed
                ans[arr[i].second] += rightCount;
                temp.push_back(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            ans[arr[i].second] += rightCount;
            temp.push_back(arr[i++]);
        }

        while (j <= r) {
            temp.push_back(arr[j++]);
        }

        for (int k = 0; k < temp.size(); k++) {
            arr[l + k] = temp[k];
        }
    }

    void mergeSort(vector<pair<int, int>>& arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        ans.assign(n, 0);

        vector<pair<int, int>> arr;
        for (int i = 0; i < n; i++) {
            arr.push_back({nums[i], i});
        }

        mergeSort(arr, 0, n - 1);
        return ans;
    }
};
