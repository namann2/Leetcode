```
class Solution {
public int[] sortArray(int[] nums) {
/*
Stable : ( order of duplicates is maintained )
MergeSort
Bubble
Insertion
____________________
In Place :
Selection Sort
Insertion Sort
*/
// Not Inplace ( as extra space is used ) | Best, worst, Avg - O(nlogn)
// mergeSort(nums, 0, nums.length-1, new int[nums.length]);
// quickSort(nums, 0, nums.length-1);