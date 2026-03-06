class Solution {
    public int climbStairs(int n) {
        if (n <= 1)
            return n;

        int curr = 1, prev = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}