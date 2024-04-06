TC :  for both is : O(2^n)
​
for loop approach :
```
private void subsets(int[] nums, int start, int n, ArrayList<Integer> temp) {
result.add(new ArrayList<>(temp)); // here adding to the final list is happening for the pick side
// in the recursion tree, and not for the notPick side, thus, we are sure that there will be no repeatitions
for(int i=start;i<n;i++) {
temp.add(nums[i]);
subsets(nums, i+1, n, temp);
temp.remove(temp.size()-1);
}
}
```
​
pick not pick approach :
​
```
​
private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
// base condition