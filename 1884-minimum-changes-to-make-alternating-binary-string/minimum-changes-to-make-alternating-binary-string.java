class Solution {
    public int minOperations(String s) {
        int startWithZero = 0; // 010101
        int startWithOne = 0; // 101010
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    startWithZero++;
                } else {
                    startWithOne++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    startWithOne++;
                } else {
                    startWithZero++;
                }
            }
        }
        return Math.min(startWithZero, startWithOne);
    }
}