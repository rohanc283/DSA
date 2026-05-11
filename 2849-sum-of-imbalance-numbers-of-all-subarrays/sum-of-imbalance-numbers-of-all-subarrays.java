class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int imbalanceCount = 0;
            set.add(nums[i]);
            for (int j = i + 1; j < n; j++) {
                int num = nums[j];
                if (!set.contains(num)) {
                    if (set.contains(num - 1) && set.contains(num + 1)) {
                        imbalanceCount--;
                    } else if (!set.contains(num - 1) && !set.contains(num + 1)) {
                        imbalanceCount++;
                    }
                    set.add(nums[j]);
                }
                res += imbalanceCount;
            }
        }
        return res;
    }
}