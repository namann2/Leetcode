class Solution {
    public int[] smallestSubarrays(int[] nums) {
        // bit manipulation
        int n = nums.length;
        int[]answer = new int[n];
        
        int max_or = 0;
        for(int num : nums) 
            max_or |= num;
        
        int bit = 0;
        for(int i=0;i<32;i++) {
            if((max_or & (1<<i)) == 1)
            {
                bit = i;
                break;
            }
        }
        // we need to find the index of such an element for which 
        // when we go incrementally till that index, the unset positions 
        // of the current number is set such that the number of set bits required
        // is equal to that of the max_or
        
        // bit position -> [index of number for which this bit position is set]
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=bit;i<32;i++)
            map.put(i, new TreeSet<>());
        
        for(int i=0;i<n;i++) {
            int num = nums[i];
            for(int j=bit;j<32;j++) {
                if(((num >> j) & 1) == 1) map.get(j).add(i);
            }
        }
        
        // printMap(map);
        
        for(int i=0;i<n;i++) {
            int cnum = nums[i];
            int max = i;
            for(int bitpos : map.keySet()) {
                if(((cnum >> bitpos) & 1) == 1) continue;
                Integer index = map.get(bitpos).ceiling(i);
                if(index != null)
                    max = Math.max(max, index);
            }
            answer[i] = max - i + 1;
        }
        return answer;
    }
    
    public void printMap(TreeMap<Integer, TreeSet<Integer>> map) {
        for(int i=0;i<32;i++)
        {   
            if(map.get(i).size() == 0) continue;
            System.out.print(i+" th position set of indices : ");
            for(int index : map.get(i))
                System.out.print(index+" , ");
            System.out.println();
        }
    }
}



