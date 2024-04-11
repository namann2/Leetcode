class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[]ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && T[stack.peekLast()] <= T[i]) stack.removeLast();
            ans[i] = stack.size() > 0 ? stack.peekLast() - i : 0;
            stack.addLast(i);
        }
        return ans;
    }
}