class TimeMap {

    class TimestampValue {
        public String value;
        public int timestamp;

        TimestampValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimestampValue>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, h -> new ArrayList<>());
        data.get(key).add(new TimestampValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (!data.containsKey(key))
            return res;
        List<TimestampValue> timestampValues = data.get(key);
        int s = 0, e = timestampValues.size() - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (timestampValues.get(m).timestamp <= timestamp) {
                res = timestampValues.get(m).value;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return res;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */