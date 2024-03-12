if(dp[index][k] != null)
return dp[index][k];
// main logic
// k - 1 jump
boolean op1 = false, op2 = false, op3 = false;
if(k - 1 > 0 && map.containsKey(stones[index] + k - 1) && visited.add(new int[]{stones[index] + k - 1, k - 1}))
op1 = canCross(stones, map.get(stones[index] + k - 1), k - 1, n, map);
if(op1) return true;
// k jump
if(map.containsKey(stones[index] + k) && visited.add(new int[]{stones[index] + k, k}))
op2 = canCross(stones, map.get(stones[index] + k), k , n, map);
if(op2) return true;
// k+1 jump
if(map.containsKey(stones[index] + k + 1) && visited.add(new int[]{stones[index] + k + 1, k + 1}))
op3 = canCross(stones, map.get(stones[index] + k + 1), k + 1, n, map);
if(op3) return true;
return dp[index][k] = op1 || op2 || op3;
}
}
```
2. For a particular index, given the jump we need to mark it visited. Marking the index visited based on the number of jumps is important, since it is a variable that makes the reach possible. It is possible to reach a particular index with many different jumps, and also possible that we are reaching the particular index with same jumps several times. If we have traversed the jumps ahead from it and we know that we are not able / able to reach the final index from this index ( given this particular jump ), we need to store it to avoid re-computation in later times. hence, dp is used & visited hashset stores the int[] with index and jump.