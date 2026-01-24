class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer[] numList = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numList);

        int ans = 0, closestSum = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1, e = n - 1;
            while (s < e) {
                int sum = numList[i] + numList[s] + numList[e];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < closestSum) {
                        closestSum = Math.abs(sum - target);
                        ans = sum;
                    }
                    e--;
                } else {
                    if (Math.abs(sum - target) < closestSum) {
                        closestSum = Math.abs(sum - target);
                        ans = sum;
                    }
                    s++;
                }
            }
        }
        return ans;
    }
}