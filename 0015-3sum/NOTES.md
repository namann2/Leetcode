## Approach 1 : 

Using HashSet to remove duplicates
TC : O(n^2)
SC : O(n)

```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i = 0; i < n; i ++) {
            int j = i+1, k = n-1;
            while(j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                if(curr_sum == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(curr_sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(ans);
    }
}
```
<br>

## Approach 2 : Better Approach
Removing the usage of hashset

```
class Solution {
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

```
<br/>

## Approach 3 : NO SORT

Without sorting : 
@votrubac
Addressing several question regarding the "No-Sort" approach. We recommend approach 1 for interviews, and approach 3 is to address a possible follow-up question (e.g. "what if you cannot sort the array"). The point here is that it's possible, though the efficiency would heavily depend on the input. If we have a very large array with many duplicates and a few matching triplets, the "No-Sort" approach would be more memory efficient.

```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> starts = new HashSet<>();
        // required sum with i as starting point of the triplet, 
        // to keep a check that the triplet we are formulating
        // starts with index >= i
        Map<Integer,Integer> requiredSumWithI = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // check if unique start point
            if(starts.add(nums[i])) {
                for(int j = i + 1; j < n; j++) {
                    // the required number
                    int third = -(nums[i] + nums[j]);
                    if(requiredSumWithI.containsKey(third) && requiredSumWithI.get(third) >= i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                        // sorting a triplet 
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    // update the index of the number to check 
                    // if this can contribute for a triplet ahead
                    requiredSumWithI.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

```
