class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int n = nums.size();
        if (n < 2)
            return 0;

        int mini = *min_element(nums.begin(), nums.end());
        int maxi = *max_element(nums.begin(), nums.end());

        // bucket size (minimum possible max gap)
        int bucketSize = ceil((double)(maxi - mini) / (n - 1));
        if (bucketSize == 0)
            bucketSize = 1;

        // number of buckets = n - 1
        vector<int> minBucket(n - 1, INT_MAX);
        vector<int> maxBucket(n - 1, INT_MIN);

        // distribute numbers into buckets
        for (int num : nums) {
            if (num == mini || num == maxi)
                continue;
            int idx = (num - mini) / bucketSize;
            minBucket[idx] = min(minBucket[idx], num);
            maxBucket[idx] = max(maxBucket[idx], num);
        }

        // compute maximum gap
        int ans = 0;
        int prev = mini;

        for (int i = 0; i < n - 1; i++) {
            if (minBucket[i] == INT_MAX)
                continue; // empty bucket
            ans = max(ans, minBucket[i] - prev);
            prev = maxBucket[i];
        }

        // final gap with maximum element
        ans = max(ans, maxi - prev);

        return ans;
    }
};
