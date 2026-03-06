class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        List<int[]> temp = new ArrayList<>();
        for (int[] p : people) {
            temp.add(p[1], p);
        }
        return temp.toArray(new int[temp.size()][]);
    }
}