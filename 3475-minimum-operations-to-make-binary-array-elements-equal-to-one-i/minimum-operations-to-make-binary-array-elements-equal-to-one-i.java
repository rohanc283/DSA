class Solution {
    public int sol1(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && nums[i - k] == 5) {
                flipCount--;
            }

            if (flipCount % 2 == nums[i]) {
                if (i + k > n)
                    return -1;
                flipCount++;
                flips++;
                nums[i] = 5;
            }

        }
        return flips;
    }

    public int sol2(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i - k >= 0) {
                flipCount -= queue.getFirst();
                queue.removeFirst();
            }

            if (flipCount % 2 == nums[i]) {
                if (i + k > n)
                    return -1;
                flipCount++;
                flips++;
                queue.addLast(1);
            } else {
                queue.addLast(0);
            }
        }
        return flips;
    }

    public int minOperations(int[] nums) {
        return sol1(nums, 3);
    }
}