class Solution {
    private void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }

    public void reverse(List<Integer> nums, int s, int e) {
        while (s < e) {
            swap(nums, s++, e--);
        }
    }

    private int buildAns(List<Integer> nums) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
            if ((long) ans * 10 + nums.get(i) > Integer.MAX_VALUE) {
                return -1;
            }
            ans = ans * 10 + nums.get(i);
        }
        return ans;
    }

    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        Collections.reverse(nums);

        int breakPoint = -1, s = nums.size();
        for (int i = s - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            return -1;
        }

        for (int i = s - 1; i >= 0; i--) {
            if (nums.get(i) > nums.get(breakPoint)) {
                swap(nums, i, breakPoint);
                break;
            }
        }

        reverse(nums, breakPoint + 1, s - 1);
        return buildAns(nums);
    }
}