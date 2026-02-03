class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = nums[0];
        boolean seqBroke = false;
        set.add(sum);
        for (int i = 1; i < nums.length; i++) {
            if (seqBroke == false && nums[i - 1] + 1 == nums[i]) {
                sum += nums[i];
            } else {
                seqBroke = true;
            }
            set.add(nums[i]);
        }
        while (set.contains(sum))
            sum++;
        return sum;
    }
}