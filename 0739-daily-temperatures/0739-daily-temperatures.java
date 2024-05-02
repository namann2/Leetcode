class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[]ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i])
                stack.removeLast();
            ans[i] = stack.size() == 0 ? 0 : stack.peekLast() - i;
            stack.addLast(i);
        }
        return ans;
    }
}