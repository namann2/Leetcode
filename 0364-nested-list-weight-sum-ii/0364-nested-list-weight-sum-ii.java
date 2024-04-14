/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return weightedSum(nestedList, maxDepth, 1);
    }
    private int findMaxDepth(List<NestedInteger> nestedList) {
        int cd = 1;
        for(NestedInteger ni : nestedList) {
            if(!ni.isInteger() && ni.getList().size() > 0) {
                cd = Math.max(cd, 1 + findMaxDepth(ni.getList()));
            }
        }
        return cd;
    }
    private int weightedSum(List<NestedInteger> nestedList, int maxDepth, int depth) {
        int ans = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                ans += (maxDepth - depth + 1) * ni.getInteger();
            } else {
                ans += weightedSum(ni.getList(), maxDepth, depth + 1);
            }
        }
        return ans;
    }
}