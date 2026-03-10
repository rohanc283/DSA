class Solution {

    private int solve(int curr, int clip, int n) {

        if (curr == n)
            return 0;

        if (curr > n)
            return Integer.MAX_VALUE;

        int paste = Integer.MAX_VALUE;
        int copyPaste = Integer.MAX_VALUE;

        if (clip > 0) {
            int next = solve(curr + clip, clip, n);
            if (next != Integer.MAX_VALUE)
                paste = 1 + next;
        }

        int next = solve(curr * 2, curr, n);
        if (next != Integer.MAX_VALUE)
            copyPaste = 2 + next;

        return Math.min(paste, copyPaste);
    }

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        return 1 + solve(1, 1, n);
    }
}