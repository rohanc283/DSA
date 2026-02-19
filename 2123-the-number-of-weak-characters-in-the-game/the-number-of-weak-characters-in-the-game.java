class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0, maxDef = Integer.MIN_VALUE;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < maxDef)
                res++;
            maxDef = Math.max(maxDef, properties[i][1]);
        }
        return res;
    }
}