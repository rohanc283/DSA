import java.util.*;

class Solution {

    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        Stack<Robot> stack = new Stack<>();

        for (Robot current : robots) {

            if (current.direction == 'R') {
                stack.push(current);
            } else {

                while (!stack.isEmpty() &&
                        stack.peek().direction == 'R' &&
                        current.health > 0) {

                    Robot top = stack.peek();

                    if (top.health < current.health) {
                        stack.pop();
                        current.health--;
                    } else if (top.health == current.health) {
                        stack.pop();
                        current.health = 0;
                        break;
                    } else {
                        top.health--;
                        current.health = 0;
                        break;
                    }
                }

                if (current.health > 0) {
                    stack.push(current);
                }
            }
        }

        List<Robot> survivors = new ArrayList<>(stack);

        Collections.sort(survivors, (a, b) -> a.index - b.index);

        List<Integer> result = new ArrayList<>();
        for (Robot r : survivors) {
            result.add(r.health);
        }

        return result;
    }
}