
class Solution {
    public int maximumScoreStackSol(int[] nums, int k) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (left[i] < k && right[i] > k) {
                int width = right[i] - left[i] - 1;
                res = Math.max(res, nums[i] * width);
            }
        }
        return res;
    }

    public int maximumScore(int[] nums, int k) {
        // int i = k, j = k, n = nums.length;
        // int res = nums[k], currMin = nums[k];
        // while (i > 0 || j < n - 1) {
        //     int leftVal = i > 0 ? nums[i - 1] : 0;
        //     int rightVal = j < n - 1 ? nums[j + 1] : 0;
        //     if (leftVal < rightVal) {
        //         j++;
        //         currMin = Math.min(currMin, nums[j]);
        //     } else {
        //         i--;
        //         currMin = Math.min(currMin, nums[i]);
        //     }
        //     res = Math.max(res, currMin * (j - i + 1));
        // }
        // return res;
        return maximumScoreStackSol(nums, k);
    }
}