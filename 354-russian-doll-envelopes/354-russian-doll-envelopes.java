class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // why are sorting it by both params if w and h are equal ?
        // 1. We do not want them in the same sequence
        // 2. We would want to accomodate the larget h envelope in case w's are equal so that we can russian doll more
        Arrays.sort(envelopes, (e1, e2) -> {
            return e1[0] != e2[0] ? e1[0] - e2[0] : e2[1] - e1[1]; // sort on the basis of width
        });
        List<int[]> list = new ArrayList<>();
        list.add(envelopes[0]);
        
        int n = envelopes.length;
        for(int i=1;i<n;i++) {
            int[] last = list.get(list.size()-1);
            if(last[1] < envelopes[i][1]) list.add(envelopes[i]);
            else {
                int index = findIndex(list, envelopes[i]);
                list.set(index, envelopes[i]);
            }
        }
        return list.size();
    }
    private int findIndex(List<int[]> l, int[] envelope) {
        int start = 0, end = l.size()-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(l.get(mid)[1] == envelope[1]) return mid;
            else if(l.get(mid)[1] < envelope[1]) start = mid + 1;
            else end = mid - 1;
        }
        return end+1;
    }
}