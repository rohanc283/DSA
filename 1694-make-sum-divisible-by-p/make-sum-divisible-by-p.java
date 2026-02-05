class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int total = 0;
        for (int num : nums)
            total = (total + num) % p;

        int target = total % p;
        if (target == 0)
            return 0;

        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1);
        int res = n;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int need = (curr - target + p) % p;
            if (modIndex.containsKey(need)) {
                res = Math.min(res, i - modIndex.get(need));
            }
            modIndex.put(curr, i);
        }

        return res == n ? -1 : res;
    }
}