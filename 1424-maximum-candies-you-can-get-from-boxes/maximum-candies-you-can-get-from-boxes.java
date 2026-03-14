class Solution {
    Set<Integer> visited;
    Set<Integer> foundBoxes;

    private int DFS(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes) {
        if (visited.contains(box))
            return 0;
        if (status[box] == 0) {
            foundBoxes.add(box);
            return 0;
        }
        visited.add(box);
        int candiesCollected = candies[box];
        for (int insideBox : containedBoxes[box]) {
            candiesCollected += DFS(insideBox, status, candies, keys, containedBoxes);
        }
        for (int key : keys[box]) {
            status[key] = 1;
            if (foundBoxes.contains(key)) {
                candiesCollected += DFS(key, status, candies, keys, containedBoxes);
            }
        }
        return candiesCollected;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int totalCandies = 0;
        visited = new HashSet<>();
        foundBoxes = new HashSet<>();
        for (int box : initialBoxes) {
            totalCandies += DFS(box, status, candies, keys, containedBoxes);
        }
        return totalCandies;
    }
}