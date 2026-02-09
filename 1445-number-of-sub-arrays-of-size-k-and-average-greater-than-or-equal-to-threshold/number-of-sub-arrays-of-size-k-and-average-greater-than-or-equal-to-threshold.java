class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0, sum = 0;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (j >= k - 1) {
                double avg = sum / k;
                if (avg >= threshold)
                    res++;
                sum -= arr[i++];
            }
        }
        return res;
    }
}