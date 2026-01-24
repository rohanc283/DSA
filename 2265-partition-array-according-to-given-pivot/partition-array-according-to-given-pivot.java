class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int k = 0;

        for (int num : nums) {
            if (num < pivot) {
                res[k++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                res[k++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                res[k++] = num;
            }
        }
        return res;
    }
}
