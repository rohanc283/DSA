class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int s = 0, e = n - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (prefix[mid] <= queries[i]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            res[i] = s;
        }
        return res;
    }
}