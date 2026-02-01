class Solution {
    public boolean checkXor(int[] derived, int start) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start;
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = (derived[i] ^ original[i]);
        }
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }

    public boolean doesValidArrayExist(int[] derived) {
        if (derived[0] == 0) {
            return checkXor(derived, 0);
        }
        return checkXor(derived, 0) || checkXor(derived, 1);
    }
}