
```
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {        
        int n = A.length, m = B.length;
        
        if(n>m) return findMedianSortedArrays(B, A);
        
        int total = n+m;
        
        int halfs = (total+1)/2;
        /*
            if total # of elements = 
            1. even eg : 10, each half will have 5 elements each
            2. odd eg : 7, 
                I am assuming the answer should lie in the first half so,
                I will take more # of elements in left half so, total+1 makes that
                sure.
                this change will not affect the even case
                
            
            TC : O(log(min(n,m)))
                 as we are applying binarysearch on the array which has smaller length
        */
        
        int start = 0, end = n; // why n ?
        // because we are essentially considering number of elements from the first array. At max, we can consider all elements i.e. n
        /*
        
        if pA = 3
                       pA
                        |
            a1 a2 a3 | a4 a5
            0. 1.  2.  3. 4
            
            --left-- | -right-
            
            why end = n and not n-1 ?
            pA states the number of elements in the left A array
            pB states the number of elements in the left B array
            
						so if pA = 4, means 4 elements from 0-3 index are on left.
						and we can say, pA th index is not inclusive on the left portion.
						
            In the possible case, we can include everything from 'A' array in the 
            left portion so for this, the cut/partition will be at 'n'
        */
        while(start<=end) {
            // total number of elements from array A in the first half
            int pA = start+(end-start)/2;
            // total number of elements from array B in the first half
            int pB = halfs - pA;
            
            int l1 = pA == 0 ? Integer.MIN_VALUE : A[pA-1];
            int l2 = pB == 0 ? Integer.MIN_VALUE : B[pB-1];
            
            int r1 = pA == n ? Integer.MAX_VALUE : A[pA];
            int r2 = pB == m ? Integer.MAX_VALUE : B[pB];
            
            if(l1 <= r2 && l2 <= r1) {                
                if(total % 2 == 0) {
                    // find max on left side
                    int lMax = Math.max(l1, l2);
                    // find min on right side
                    int rMin = Math.min(r1, r2);
                    return (lMax + rMin) / 2.0;
                } else {
                    return (double) Math.max(l1, l2);
                }
            }
            else if(l1 > r2) {
                end = pA-1;
            }
            else if(l2 > r1) {
                start = pA+1;
            }
        }
        return 0.0;
    }
}
```
