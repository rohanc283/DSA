import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }
        int count = (n - map.size()) * 2;
        for (Set<Integer> reserved : map.values()) {

            boolean left = !(reserved.contains(2) || reserved.contains(3) ||
                    reserved.contains(4) || reserved.contains(5));

            boolean right = !(reserved.contains(6) || reserved.contains(7) ||
                    reserved.contains(8) || reserved.contains(9));

            boolean middle = !(reserved.contains(4) || reserved.contains(5) ||
                    reserved.contains(6) || reserved.contains(7));

            if (left && right)
                count += 2;
            else if (left || right || middle)
                count += 1;
        }
        return count;
    }
}