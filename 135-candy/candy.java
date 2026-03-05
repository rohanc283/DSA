class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int candy = n;
        int i = 0;

        while (i < n - 1) {

            if (ratings[i] == ratings[i + 1]) {
                i++;
                continue;
            }

            int peak = 0;

            while (i + 1 < n && ratings[i] < ratings[i + 1]) {
                peak++;
                candy += peak;
                i++;
            }

            int dip = 0;

            while (i + 1 < n && ratings[i] > ratings[i + 1]) {
                dip++;
                candy += dip;
                i++;
            }

            candy -= Math.min(peak, dip);
        }

        return candy;
    }
}