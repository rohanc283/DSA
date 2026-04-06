class Solution {
    public int minBitFlips(int start, int goal) {
        int flips = 0;
        // while (start > 0 || goal > 0) {
        //     int gd = (goal & 1) >= 1 ? 1 : 0;
        //     int sd = (start & 1) >= 1 ? 1 : 0;
        //     if (gd != sd)
        //         flips++;
        //     goal = goal >> 1;
        //     start = start >> 1;
        // }
        // return flips;
        int x = start ^ goal;
        while (x > 0) {
            flips++;
            x = x & (x - 1);
        }
        return flips;
    }
}