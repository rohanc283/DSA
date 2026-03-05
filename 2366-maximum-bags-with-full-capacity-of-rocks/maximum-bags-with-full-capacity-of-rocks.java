class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] need = new int[n];

        for (int i = 0; i < n; i++) {
            need[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(need);

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (additionalRocks < need[i])
                break;
            additionalRocks -= need[i];
            res++;
        }

        return res;
    }
}