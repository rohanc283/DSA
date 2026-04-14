class Solution {
    public String largestNumber(int[] nums) {
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero)
            return "0";
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            String x = a + "" + b;
            String y = b + "" + a;
            int v = x.compareTo(y);
            if (v < 0)
                return 1;
            else if (v == 0)
                return 0;
            return -1;
        }).map(String::valueOf).collect(Collectors.joining());
    }
}