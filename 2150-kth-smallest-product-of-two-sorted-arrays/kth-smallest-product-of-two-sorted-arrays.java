class Solution {
    public long countSmallestProduct(int[] nums1, int[] nums2, long midProduct) {
        int n1 = nums1.length, n2 = nums2.length;
        long productsCount = 0;

        for (int i = 0; i < n1; i++) {
            long num = nums1[i];

            if (num >= 0) {
                int l = 0, h = n2 - 1;
                int m = -1;

                while (l <= h) {
                    int mid = l + (h - l) / 2;
                    long prod = num * 1L * nums2[mid];

                    if (prod <= midProduct) {
                        m = mid;
                        l = mid + 1;
                    } else {
                        h = mid - 1;
                    }
                }
                productsCount += (m + 1);
            } else {
                int l = 0, h = n2 - 1;
                int m = n2;

                while (l <= h) {
                    int mid = l + (h - l) / 2;
                    long prod = num * 1L * nums2[mid];

                    if (prod <= midProduct) {
                        m = mid;
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                productsCount += (n2 - m);
            }
        }
        return productsCount;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = -10_000_000_000L, h = 10_000_000_000L;
        long res = 0;

        while (l <= h) {
            long midProduct = l + (h - l) / 2;
            long countSmallest = countSmallestProduct(nums1, nums2, midProduct);

            if (countSmallest >= k) {
                res = midProduct;
                h = midProduct - 1;
            } else {
                l = midProduct + 1;
            }
        }
        return res;
    }
}