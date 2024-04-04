class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = asteroids.length;
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.addLast(asteroid);
            } else if(stack.isEmpty() || stack.peekLast() < 0) {
                stack.addLast(asteroid);
            } else {
                boolean isDestroyed = false;
                while(!stack.isEmpty() && stack.peekLast() > 0) {
                    // case 1
                    if(stack.peekLast() < -1*asteroid) {
                        stack.removeLast();
                    }
                    // case 2
                    else if(stack.peekLast() > -1*asteroid) {
                        isDestroyed = true;
                        break;
                    }
                    // case 3
                    else {
                        isDestroyed = true;
                        stack.removeLast();
                        break;
                    }
                }
                if(!isDestroyed) stack.addLast(asteroid);
            }
        }
        int ans[] = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()) {
            ans[idx++] = stack.removeFirst();
        }
        return ans;
    }
}