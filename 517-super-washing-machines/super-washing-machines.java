class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int m : machines)
            sum += m;

        int n = machines.length;
        if (sum % n != 0)
            return -1;

        int target = sum / n;
        int flow = 0;
        int ans = 0;

        for (int m : machines) {
            int diff = m - target;
            flow += diff;

            ans = Math.max(ans, Math.max(Math.abs(flow), diff));
        }

        return ans;
    }
}