class Solution {
    public boolean isPowerOfThree(int n) {
        int power = 1;
        for (int i = 0; i < 32; i++) {
            if (power == n)
                return true;
            if (power > n)
                break;

            if (power < Integer.MAX_VALUE / 3) {
                power = power * 3;
            } else {
                break;
            }
        }
        return false;
    }
}