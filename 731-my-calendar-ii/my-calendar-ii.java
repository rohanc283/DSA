class MyCalendarTwo {

    Map<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);
        int curr = 0;
        boolean isTrippleBooking = false;
        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            curr += entry.getValue();
            if (curr >= 3) {
                isTrippleBooking = true;
                break;
            }
        }
        if (isTrippleBooking) {
            events.put(startTime, events.get(startTime) - 1);
            events.put(endTime, events.get(endTime) + 1);
        }
        return !isTrippleBooking;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */