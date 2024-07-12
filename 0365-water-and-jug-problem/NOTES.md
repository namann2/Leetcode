```
Way 1 : Mathlogger Video ( Just for fun )
​
class Solution {
public boolean canMeasureWater(int CA, int CB, int k) {
if(CA+CB < k) return false;
int gcd = gcd(CA, CB);
return k%gcd == 0;
}
private int gcd(int a, int b) {//a -> dividend , b -> divisor
if(a==0) return b;
return gcd(b%a, a);
}
}
​
Eculidan method to find HCF
// 6, 15
//     6|15
//      -12
//        3|6
//         -6
//          0|3
```
​
​
# Way 2 :
```
class Pair{
int jug1, jug2;
Pair(int jug1, int jug2) {
this.jug1 = jug1;
this.jug2 = jug2;
}
}
class Solution {
public boolean canMeasureWater(int CA, int CB, int k) {
if(CA + CB < k) return false;
Queue<Pair> q = new LinkedList<>();
q.add(new Pair(0,0));
HashSet<String> vis = new HashSet<>();
while(!q.isEmpty()) {
Pair get = q.poll();
vis.add(String.valueOf(get.jug1+","+get.jug2));
if(!vis.contains(String.valueOf(newJug1+","+newJug2))) {