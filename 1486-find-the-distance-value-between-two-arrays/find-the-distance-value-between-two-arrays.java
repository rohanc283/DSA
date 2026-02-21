class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;

        for (int num : arr1) {
            int left = 0, right = arr2.length - 1;
            boolean isValid = true;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (Math.abs(arr2[mid] - num) <= d) {
                    isValid = false;
                    break;
                } else if (arr2[mid] < num - d) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (isValid)
                res++;
        }
        return res;
    }
}