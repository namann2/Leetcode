Related Problem : 
- https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
- Google Interview Problem : 
  <img width="1229" alt="Screenshot 2024-11-24 at 1 54 01 PM" src="https://github.com/user-attachments/assets/e7440ba2-9b68-4e9e-820d-eb2028827780">


Solution : 
https://leetcode.com/playground/5xJvfy7U

Other simplified way to implement this :

```
class Pair {
    int index, value, inv;
    public Pair(int index, int value, int inv) {
        this.index = index;
        this.value = value;
        this.inv = 0;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        
        Pair[] list = new Pair[n];
        for(int i = 0; i < n; i++) {
            list[i] = new Pair(i, nums[i], 0);
        }
        
        mergeSort(list, 0, n-1, new Pair[n]);
        
        for(int i = 0; i < n; i++) answer.add(0);
        
        for(Pair p : list) {
            answer.set(p.index, p.inv);
        }
        
        return answer;
    }
    
    private void mergeSort(Pair[] nums, int leftStart, int rightEnd, Pair[] temp) {
        if(leftStart >= rightEnd) {
            return;
        }
        
        int mid = leftStart + (rightEnd - leftStart) / 2;
        mergeSort(nums, leftStart, mid, temp);
        mergeSort(nums, mid + 1, rightEnd, temp);
        mergeHalves(nums, leftStart, rightEnd, temp);
    }
    
    private void mergeHalves(Pair[] nums, int leftStart, int rightEnd, Pair[] temp) {
        int leftEnd = leftStart + (rightEnd - leftStart) / 2;
        int rightStart = leftEnd + 1;
        
        int left = leftStart, right = rightStart, ptr = left;
        int cnt = 0;
        
        while(left <= leftEnd && right <= rightEnd) {
            if(nums[left].value > nums[right].value) {
                cnt++;
                temp[ptr++] = nums[right++];
            } else {
                nums[left].inv += cnt;
                temp[ptr++] = nums[left++];
            }
        }
        
        while(left <= leftEnd) {
            nums[left].inv += cnt;
            temp[ptr++] = nums[left++];
        }
        
        while(right <= rightEnd) {
            temp[ptr++] = nums[right++];
        }
        
        for(; leftStart <= rightEnd; leftStart++)
            nums[leftStart] = temp[leftStart];
    }
}
```
