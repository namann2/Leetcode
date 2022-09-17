class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int total = a + b + c;
        int A = 0, B = 0, C = 0;
        
        while(total-- > 0) {
            // fill A
            if((a>0 && A!=2 && a>=b && a>=c) || (a>0 && B==2) || (a>0 && C == 2)) {
                result.append("a");
                A++;
                a--;
                B = C = 0;
            }
            // fill B
            else if((b>0 && B!=2 && b>=a && b>=c) || (b>0 && A==2) || (b>0 && C==2)) {
                result.append("b");
                B++;
                b--;
                A = C = 0;
            }
            // fill C
            else if((c>0 && C!=2 && c>=a && c>=b) || (c>0 && A==2) || (c>0 && B==2)) {
                result.append("c");
                C++;
                c--;
                A = B = 0;
            }
        }
        return result.toString();
    }
}