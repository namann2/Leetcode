​# Naive Approach : N2
```
int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int LIS = 0;
        for(int i=1;i<n;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            LIS = Math.max(LIS, dp[i]);
            if(LIS == 3) return true;
        }
        return false;
```


# Optimal LIS Approach : We can update the code with early break
```
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<n;i++) {
            int last = temp.get(temp.size()-1);
            // strictly increasing hence, > and not >=
            if(nums[i] > last) temp.add(nums[i]);
            else {
                int index = binarySearch(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }
        return temp.size() >= 3;
    }
    private int binarySearch(List<Integer> temp, int el) {
        int left = 0, right = temp.size()-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(temp.get(mid) == el) return mid;
            else if(temp.get(mid) < el) left = mid + 1;
            else right = mid - 1;
        }
        return right + 1;
    }
}
```
