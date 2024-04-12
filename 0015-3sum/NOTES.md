public List<List<Integer>> threeSum(int[] nums) {
int n = nums.length;
Arrays.sort(nums);
List<List<Integer>> ans = new ArrayList<>();
for(int i = 0; i < n - 2; i++) {
if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for i
int j = i + 1, k = n - 1;
while(j < k) {
int curr_sum = nums[i] + nums[j] + nums[k];
if(curr_sum == 0) {
ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicates for j
while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicates for k
j++;
k--;
} else if(curr_sum > 0) {
k--;
} else {
j++;
}
}
}
return ans;
}
}
​
```
​
​
## Approach 3 :
​
Without sorting :
@votrubac
Addressing several question regarding the "No-Sort" approach. We recommend approach 1 for interviews, and approach 3 is to address a possible follow-up question (e.g. "what if you cannot sort the array"). The point here is that it's possible, though the efficiency would heavily depend on the input. If we have a very large array with many duplicates and a few matching triplets, the "No-Sort" approach would be more memory efficient.
​
​
​