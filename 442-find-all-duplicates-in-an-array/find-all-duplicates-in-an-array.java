class Solution {
    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0, n = nums.length;
        Set<Integer> ansList = new HashSet<>();
        while (i < n) {
            if (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    ansList.add(nums[i]);
                    i++;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            } else {
                i++;
            }
        }
        return new ArrayList<>(ansList);
    }
}