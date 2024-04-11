class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[]ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
            ans[i] = stack.size() > 0 ? stack.peek() - i : 0;
            stack.push(i);
        }
        return ans;
    }
}