```
class Solution {
/*
Way 1 : We could use HashSet here but constraint is O(1) SC
Way 2 : Cyclic Sort
https://leetcode.com/problems/first-missing-positive/discuss/858526/Cyclic-Sort-Explained
https://emre.me/coding-patterns/cyclic-sort/
Similar problem :
​
https://leetcode.com/problems/find-all-duplicates-in-an-array/
Complete Logic :
​
All the questions where we need to find the repeating numbers, or missing numbers can easily be solved with the help of a pattern that is cyclic sort. In this pattern we simply place the elements of the array on their positions( or at least try to ), like 1 should be at 1st position and 2 at the second position, and then we iterate again and check if for any index we have an element whose value is not equal to index + 1, then that is the missing number.
​
You can follow this link to learn more
​
In this question we can simply ignore the -ve elements as we only need to find the smallest positive element, so we ignore elements that are less than 0 and greater than arrays length and swap only if the element is not at its correct posiition. Then we iterate again and find the missing number and return it.
​