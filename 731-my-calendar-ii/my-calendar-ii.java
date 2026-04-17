class MyCalendarTwo {

    Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
        int intersection = 0;
        int curr = 0;
        for (Integer timing : map.keySet()) {
            curr += map.get(timing);
            intersection = Math.max(intersection, curr);
        }
        if (intersection >= 3) {
            map.put(startTime, map.get(startTime) - 1);
            map.put(endTime, map.get(endTime) + 1);
            return false;
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */