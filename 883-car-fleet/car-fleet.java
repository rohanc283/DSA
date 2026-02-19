class Solution {
    class Car {
        public int position;
        public double timeToTarget;

        Car(int position, double timeToTarget) {
            this.position = position;
            this.timeToTarget = timeToTarget;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n <= 1)
            return n;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], ((target - position[i]) * 1.0) / (1.0 * speed[i]));
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));
        int res = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (cars[i].timeToTarget >= cars[i - 1].timeToTarget) {
                cars[i - 1] = cars[i];
            } else {
                res++;
            }
        }
        return res + 1;
    }
}