# LOGIC : 

no need to look for any tutorial, just read through the explanation : 

We will have to count those subarrays in which A[i] is the minimum. 

- On the left  ( Number of subarrays where A[i] is minimum on the left ) [ ...... i ]
- On the right ( Number of subarrays where A[i] is minimum on the right ) [ i+1...... ]
            
It is because, we are aiming to find the number of subarrays to the left, in which A[i] will be the 
smallest. and same for the right hand side.
            
            index = [0, 1, 2, 3]
            A =     [3, 1, 2, 4]
            left =  [1, 2, 1, 1]
            right=  [1, 3, 2, 1]
            
let take A[1] information,
we have 2 subarrays for which A[1] is the smallest in the left
we have 3 subarrays for which A[1] is the smallest in the right

Total subarrays in which A[i] is the min, 2 * 3 How ?
            
left subarray portion : [3, 1]
  - all subarrays : [3,1], [1]

right subarray portion : [1, 2, 4]
  - all subarrays : [1], [1,2] , [1, 2, 4]
                
But we missed those subarrays where left and right combine right !
            [3, 1, 2], [3, 1, 2, 4]
            
total unique subarrays where A[1] is min = [3,1], [1], [1,2] , [1, 2, 4], [3, 1, 2], [3, 1, 2, 4]
is 6. Hence the formula : left[1] * right[1]

```
class Solution {
    public int sumSubarrayMins(int[] A) {
        // return the sum of minimums of all subarrays
        // the O(n2) is intuitive - We can use gap method ,
        // but how can we reduce it to O(n)
        
        int n = A.length, mod = (int)1e9+7;
        int[]left = new int[n], right = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0);
        left[0] = 1;
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) { // just add " = " in either condition
                stack.pop();
            }
            left[i] = stack.size() == 0 ? i+1 : i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        stack.push(n-1);
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            right[i] = stack.size() == 0 ? n-i : stack.peek()-i;
            stack.push(i);
        }
        
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        
        long result = 0;
        for(int i=0;i<n;i++) {
            long l = left[i]%mod;
            long r = right[i]%mod;
            result += (A[i] * l * r) % mod;
        }
        
        return (int)result % mod;
```
