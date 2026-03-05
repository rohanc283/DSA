class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i = horizontalCut.length - 1, j = verticalCut.length - 1;
        long horizontalPieces = 1, verticalPieces = 1;
        long cost = 0;
        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                cost += (horizontalCut[i] * verticalPieces);
                horizontalPieces++;
                i--;
            } else {
                cost += (verticalCut[j] * horizontalPieces);
                verticalPieces++;
                j--;
            }
        }
        while (i >= 0) {
            cost += (horizontalCut[i] * verticalPieces);
            horizontalPieces++;
            i--;
        }
        while (j >= 0) {
            cost += (verticalCut[j] * horizontalPieces);
            verticalPieces++;
            j--;
        }
        return (int) cost;
    }
}