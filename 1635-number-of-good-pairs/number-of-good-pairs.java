class Solution {
    public int numIdenticalPairs(int[] nums) {
        int [] freq = new int[101];
        int res = 0;
        for(int num: nums){
            if(freq[num] > 0){
                res += freq[num];
            }
            freq[num]++;
        }
        return res;
    }
}