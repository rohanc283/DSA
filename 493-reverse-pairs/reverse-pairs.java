class Solution {
    void merge(int arr[], int l, int m, int r) {
        int i = l, n1 = m, j = m + 1, n2 = r;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= n1 && j <= n2) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= n1) {
            temp[k++] = arr[i++];
        }
        while (j <= n2) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int s = l; s <= r; s++) {
            arr[s] = temp[k++];
        }
    }

    void mergeSort(int arr[], int l, int r, int[] ans) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m, ans);
        mergeSort(arr, m + 1, r, ans);
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if ((1.0 * arr[i]) / 2 > arr[j] * 1.0) {
                ans[0] += (m - i + 1);
                j++;
            } else {
                i++;
            }
        }
        merge(arr, l, m, r);
    }

    public int reversePairs(int[] nums) {
        int[] ans = new int[1];
        int n = nums.length;
        mergeSort(nums, 0, n - 1, ans);
        return ans[0];
    }
}