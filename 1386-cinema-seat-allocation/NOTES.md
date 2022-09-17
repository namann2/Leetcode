# Solution :
```
class Solution {
    public int maxNumberOfFamilies(int n, int[][] rseats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] rs : rseats) {
            if(!map.containsKey(rs[0]))
                map.put(rs[0], new HashSet<>());
            map.get(rs[0]).add(rs[1]);
        }
        
        // at max, in a row, we can arrange just 2 families
        // count all the rows which do not have any reserved seats
        int cnt = (n - map.size()) * 2;
        
        // for a particular row, we have 3 possiblities.
        // But out of those 3, we can pick 2 if we want to maximize the arrangements in groups
        /*
            23 45
                4567
                    67 89
                    
            If we pick 1 and 3, then it is easy for us to handle the cases. Why ?
            if either we have picked 1 or 3, we can not have chosen 2 in any case and as we need to maximize the
            groups, hence, if we choose arrangement 1 and 3 we can satisfy the maximum arrangements
        */
        
        for(HashSet<Integer> reservedInCurrRow : map.values()) {
        
            boolean filled = false;
            
            // choice 1
            
            if(!reservedInCurrRow.contains(2) && !reservedInCurrRow.contains(3) &&
                !reservedInCurrRow.contains(4) && !reservedInCurrRow.contains(5)) 
            {
                cnt ++;
                filled = true;
            }

            // choice 3
            
            if(!reservedInCurrRow.contains(6) && 
                    !reservedInCurrRow.contains(7) &&
                        !reservedInCurrRow.contains(8) &&
                            !reservedInCurrRow.contains(9)) 
            {
                cnt ++;
                filled = true;
            }

            // if already positioned at choice 1 or 3, then, no can do on position 2
            
            if(!filled && !reservedInCurrRow.contains(4) && !reservedInCurrRow.contains(5) &&
                !reservedInCurrRow.contains(6) && !reservedInCurrRow.contains(7)) 
            {
                cnt ++;
            }
        }
        
        return cnt;
    }
}
```
