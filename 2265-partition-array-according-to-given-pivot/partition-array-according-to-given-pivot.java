class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] relSortArr = new int[n];
        int k = 0;
        int pivotCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                relSortArr[k++] = nums[i];
            }
            if (nums[i] == pivot)
                pivotCount++;
        }
        while (pivotCount > 0) {
            relSortArr[k++] = pivot;
            pivotCount--;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                relSortArr[k++] = nums[i];
            }
        }
        return relSortArr;
    }
}