class Solution {
    public void merge(int[] nums, int s, int m, int e) {
        int i = s, j = m + 1;
        int[] temp = new int[e - s + 2];
        int k = 0;
        while (i <= m && j <= e) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }
        while (j <= e) {
            temp[k++] = nums[j++];
        }
        k = 0;
        for (int z = s; z <= e; z++) {
            nums[z] = temp[k++];
        }
    }

    public void mergeSort(int[] nums, int s, int e, int[] res) {
        if (s >= e)
            return;
        int m = s + (e - s) / 2;
        mergeSort(nums, s, m, res);
        mergeSort(nums, m + 1, e, res);
        int i = s, j = m + 1;
        while (i <= m && j <= e) {
            if ((long) nums[i] > 2L * nums[j]) {
                res[0] += (m - i + 1);
                j++;
            } else {
                i++;
            }
        }
        merge(nums, s, m, e);
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] res = new int[1];
        mergeSort(nums, 0, n - 1, res);
        return res[0];
    }
}