class Solution {
    public boolean checkXor(int[] derived, int start) {
        int n = derived.length;
        int prev = start;

        for (int i = 0; i < n - 1; i++) {
            int curr = derived[i] ^ prev;
            prev = curr;
        }

        return (prev ^ start) == derived[n - 1];
    }

    public boolean sol1(int[] derived) {
        return checkXor(derived, 0) || checkXor(derived, 1);
    }

    public boolean sol2(int[] derived) {
        int xor = derived[0];
        for (int i = 1; i < derived.length; i++) {
            xor ^= derived[i];
        }
        return xor == 0;
    }

    public boolean doesValidArrayExist(int[] derived) {
        return sol2(derived);
    }
}
