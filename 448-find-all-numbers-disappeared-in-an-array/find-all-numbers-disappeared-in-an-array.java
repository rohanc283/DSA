class Solution {
    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                ansList.add(i + 1);
        }
        return ansList;
    }
}