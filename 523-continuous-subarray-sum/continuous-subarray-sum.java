class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1);
        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = ((prefix % k) + k) % k; 

            if (modIndex.containsKey(mod)) {
                if (i - modIndex.get(mod) >= 2)
                    return true;
            } else {
                modIndex.put(mod, i); 
            }
        }

        return false;
    }
}