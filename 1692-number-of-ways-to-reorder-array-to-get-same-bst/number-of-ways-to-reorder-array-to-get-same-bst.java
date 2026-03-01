class Solution {

    List<List<Long>> PT;
    int MOD = 1_000_000_007;

    private long solve(List<Integer> nums) {
        if (nums.size() < 3)
            return 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(0))
                left.add(nums.get(i));
            else
                right.add(nums.get(i));
        }

        long leftWays = solve(left) % MOD;
        long rightWays = solve(right) % MOD;

        int totalNodes = nums.size() - 1;
        int leftSize = left.size();

        long waysToMerge = PT.get(totalNodes).get(leftSize);

        return (((leftWays * rightWays) % MOD) * waysToMerge) % MOD;
    }

    public int numOfWays(int[] nums) {

        int n = nums.length;

        List<Integer> numsList = new ArrayList<>();
        for (int x : nums)
            numsList.add(x);

        PT = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Long> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(1L);
            }
            PT.add(row);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                long val = (PT.get(i - 1).get(j)
                        + PT.get(i - 1).get(j - 1)) % MOD;
                PT.get(i).set(j, val);
            }
        }

        return (int) ((solve(numsList) - 1 + MOD) % MOD);
    }
}