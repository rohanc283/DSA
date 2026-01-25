class Solution {
    public long minimumSteps(String s) {
        long ones = 0;
        long steps = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            } else {
                steps += ones;
            }
        }
        return steps;
    }
}
