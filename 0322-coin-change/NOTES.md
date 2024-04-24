Approach. 1  : This is same as finding combinations to make a particular target.
As, we can use a coin any number of times, therefore, it would be better to use for loop approach ( For more info,
check notes section of combination problem )
​
`TC : O(2^n)`
​
```
class Solution {
int ans = Integer.MAX_VALUE;
public int coinChange(int[] coins, int amount) {
if(amount == 0) return 0;
cc(coins, 0, new ArrayList<Integer>(), amount);
return ans == Integer.MAX_VALUE ? -1 : ans;
}
private void cc(int[] coins, int index, ArrayList<Integer>temp, int k) {
if(index>=coins.length) return;
if(k == 0) {
ans = Math.min(ans, temp.size());
return;
}
if(k<0) return;
temp.add(coins[index]);