class Solution {
    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0, n = nums.length;
        List<Integer> ansList = new ArrayList<>();
        while (i < n) {
            if (nums[i] != nums[nums[i] - 1] && nums[i] - 1 != i) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                ansList.add(nums[i]);
        }
        return ansList;
    }
}