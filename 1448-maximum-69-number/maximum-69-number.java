class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int res = 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '6' && count == 0) {
                res = res * 10 + ('9' - '0');
                count = 1;
            } else {
                res = res * 10 + (c - '0');
            }
        }
        return res;
    }
}