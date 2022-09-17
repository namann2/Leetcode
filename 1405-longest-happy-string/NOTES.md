```
class Solution {
    public String longestDiverseString(int a, int b, int c) {

        int total = a+b+c;
        
        int A=0,B=0,C=0; 
        
        /* count of i-1 and i-2 chars
            eg : A A B
                     ^
                     i
                A = 2, 
                B = 0
                C = 0
        */
        
        StringBuilder result = new StringBuilder();
        while(total-- > 0) {
            if((a >= b && a >= c && A!=2) || (a>0 && B==2) || (a>0 && C==2)) {
                result.append('a');
                A++;
                a--;
                B = C = 0;
            }
            else if((b>=a && b>=c && B!=2) || (b>0 && A==2) || (b>0 && C==2)) {
                result.append('b');
                B++;
                b--;
                A = C = 0;
            }
            else if((c>=a && c>=b && C!=2) || (c>0 && A==2) || (c>0 && B==2)) {
                result.append('c');
                C++;
                c--;
                A = B = 0;
            }
        }
        return result.toString();
    }
}
```
