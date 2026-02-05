class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int cur = 0;
            set.add(nums[i]);

            for (int j = i + 1; j < n; j++) {
                int x = nums[j];

                if (!set.contains(x)) {
                    boolean hasLeft = set.contains(x - 1);
                    boolean hasRight = set.contains(x + 1);

                    if (!hasLeft && !hasRight)
                        cur += 1;
                    else if (hasLeft && hasRight)
                        cur -= 1;

                    set.add(x);
                }
                ans += cur;
            }
        }
        return ans;
    }
}