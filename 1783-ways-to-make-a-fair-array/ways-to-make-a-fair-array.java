class Solution {
    public int waysToMakeFair(int[] nums) {

        int n = nums.length;

        int totalEven = 0;
        int totalOdd = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                totalEven += nums[i];
            else
                totalOdd += nums[i];
        }

        int evenPrefix = 0;
        int oddPrefix = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0)
                totalEven -= nums[i];
            else
                totalOdd -= nums[i];

            int evenSum = evenPrefix + totalOdd;
            int oddSum = oddPrefix + totalEven;

            if (evenSum == oddSum)
                result++;

            if (i % 2 == 0)
                evenPrefix += nums[i];
            else
                oddPrefix += nums[i];
        }

        return result;
    }
}