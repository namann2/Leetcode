class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            // i j ..... k
            // Assume h[j] > h[i], ith person can not view those buildings that have heights smaller than
            // j
            while(!stack.isEmpty() && heights[i] > stack.peekLast()) {
                ans[i] += 1;
                stack.removeLast();
            }
            ans[i] += stack.size() == 0 ? 0 : 1; // current can view the building whose height[i] >= h[j]
            stack.addLast(heights[i]);
        }
        return ans;
    }
}