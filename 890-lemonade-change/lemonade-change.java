class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (map.getOrDefault(5, 0) <= 0)
                    return false;
                map.put(5, map.getOrDefault(5, 0) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else {
                int deno5 = map.getOrDefault(5, 0), deno10 = map.getOrDefault(10, 0);
                if (deno5 > 0 && deno10 > 0) {
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    map.put(10, map.getOrDefault(10, 0) - 1);
                } else if (deno5 > 2) {
                    map.put(5, map.getOrDefault(5, 0) - 3);
                } else {
                    return false;
                }
                map.put(20, map.getOrDefault(20, 0) + 1);
            }
            System.out.println(i);
        }
        return true;
    }
}