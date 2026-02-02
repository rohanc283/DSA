class Solution {
    public String intToRoman(int num) {
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] sym = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            if (num == 0)
                break;
            int times = num / value[i];
            while (times > 0) {
                res.append(sym[i]);
                times--;
            }
            num %= value[i];
        }
        return res.toString();
    }
}