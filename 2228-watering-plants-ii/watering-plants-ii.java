class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0, n = plants.length;
        int i = 0, j = n - 1;
        int aCap = capacityA, bCap = capacityB;
        while (i <= j) {
            if (i == j) {
                int cap = Math.max(aCap, bCap);
                if (plants[i] > cap) {
                    ans++;
                }
            } else {
                if (plants[i] <= aCap) {
                    aCap -= plants[i];
                } else {
                    ans++;
                    aCap = capacityA - plants[i];
                }

                if (plants[j] <= bCap) {
                    bCap -= plants[j];
                } else {
                    ans++;
                    bCap = capacityB - plants[j];
                }
            }
            i++;
            j--;
        }
        return ans;
    }
}