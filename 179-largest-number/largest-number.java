class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strList = new String[n];
        for (int i = 0; i < n; i++) {
            strList[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strList, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        if (strList[0].equals("0"))
            return "0";

        return String.join("", strList);
    }
}
