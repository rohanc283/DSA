class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>() {
            {
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");
            }
        };
        StringBuilder res = new StringBuilder();
        int[] divisor = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        int divIdx = 0;
        while (num > 0) {
            while (divisor[divIdx] > num)
                divIdx++;
            res.append(map.get(divisor[divIdx]));
            num -= divisor[divIdx];
        }
        return res.toString();
    }
}