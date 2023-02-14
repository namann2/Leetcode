```
class Solution {
public String addBinary(String a, String b) {
int i = a.length()-1, j = b.length()-1;
StringBuilder res = new StringBuilder();
int carry = 0;
while(i>=0 || j>=0) {
int sum = carry;
if(i>=0) sum += a.charAt(i--) == '1' ? 1: 0;
if(j>=0) sum += b.charAt(j--) == '1' ? 1: 0;
// 2 possibility 1+0=1 (0 carry ) or 1+1=2 ( 1 carry )
carry = sum/2;
res.append(sum%2);
}
if(carry!=0) res.append(carry);
return res.reverse().toString();
}
}
```