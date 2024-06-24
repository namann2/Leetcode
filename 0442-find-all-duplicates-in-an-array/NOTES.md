}
```
​
## Approch 2 :
​
Cycle Sort :
https://www.geeksforgeeks.org/cycle-sort/
​
```
class Solution {
public List<Integer> findDuplicates(int[] nums) {
List<Integer> answer = new ArrayList<>();
int n = nums.length;
for(int i = 0; i < n; i++) {
int correctIndex = nums[i] - 1;
if(nums[i] == nums[correctIndex]) {
continue;
} else {
int tmp = nums[correctIndex];
nums[correctIndex] = nums[i];
nums[i] = tmp;
i--;
}
}
// observation : Any elements not at the correct index are duplicates
System.out.println(Arrays.toString(nums));
for(int i = 0; i < n; i++) {
if(i+1 != nums[i])
answer.add(nums[i]);
}
return answer;
}
}
```