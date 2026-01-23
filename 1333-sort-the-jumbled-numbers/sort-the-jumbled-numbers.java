class Solution {
    private int getMappedValue(int num, int[] mapping) {
        if (num == 0)
            return mapping[num];
        int mapped = 0;
        int p = 1;
        while (num > 0) {
            int digit = num % 10;
            mapped = mapping[digit] * p + mapped;
            num /= 10;
            p *= 10;
        }
        return mapped;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] numList = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numList, (a, b) -> getMappedValue(a, mapping) - getMappedValue(b, mapping));
        for (int i = 0; i < nums.length; i++)
            nums[i] = numList[i];

        return nums;
    }
}
