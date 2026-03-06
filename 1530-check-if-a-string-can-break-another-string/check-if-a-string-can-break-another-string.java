class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);

        int counts1 = 0, counts2 = 0, n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] >= arr2[i]) {
                counts1++;
            }
            if (arr2[i] >= arr1[i]) {
                counts2++;
            }
        }
        return counts1 == n || counts2 == n;
    }
}