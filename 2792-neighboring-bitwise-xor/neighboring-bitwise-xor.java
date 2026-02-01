class Solution {
    public boolean checkXor(int[] derived, int start) {
        int n = derived.length;
        int prev = start;
        for (int i = 0; i < n - 1; i++) {
            int curr = (derived[i] ^ prev);
            prev = curr;
        }
        return (prev ^ start) == derived[n - 1];
    }

    public boolean doesValidArrayExist(int[] derived) {
        return checkXor(derived, 0) || checkXor(derived, 1);
    }
}