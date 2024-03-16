def a great question
https://leetcode.com/problems/contiguous-array/solution/
- See Tech Dose yt channel video for this
- Pepcoding video
​
```
Note :
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
and current question has same logic
Brute Force : Calculate the sums for each subarray and if it is 0, update the length
eg :
n = 8
arr = 15 -2 2 -8 1 7 10 23
For 15, possible subarray sums would be
index : 0, 1,  2, 3, 4,
15, 13, 15...
one valid subarray is -2 2 i.e.2 - 0 = 2
So, subarray sum equals zero in only 2 conditions
1. either the current element is 0
2. we found an already seen sum ( eg above )
So, we can use a hashmap
Now, in this question,
if we simulate 0 as -1 and 1 as 1 only and check if we find a sum equal 0. it
is the same logic
```