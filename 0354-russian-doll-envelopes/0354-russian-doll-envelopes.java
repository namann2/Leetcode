class Solution {
    public int maxEnvelopes(int[][] envelops) {
        /*
            About sorting,
            [[3,2],[3,2],[2,3],[2,2],[3,4],[3,6],[6,6]]
            if we sort it like so,
                if(e1[0] == e2[0]) return e1[1] - e2[1];
                return e1[0] - e2[0];
            what issue is there ? Let's only write the height of our so called sorted array
            2 3 2 2 4 6 6 
            in this case, 3 can allow 2 be put inside but in actual this is wrong, since the width of 
            this envelope having h = 2, is same as that of envelope with h = 3.
            Hence, we want to keep the largest of height before to avoid this issue.
        */
        Arrays.sort(envelops, (e1, e2) -> {
            if(e1[0] == e2[0]) return e2[1] - e1[1];
            return e1[0] - e2[0];
        });
        
        int length = 1, n = envelops.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(envelops[0][1]);
        
        for(int i=1;i<n;i++) {
            int prev = list.get(list.size()-1);
            if(prev < envelops[i][1]) {
                list.add(envelops[i][1]);
            } else {
                int index = binarySearch(list, envelops[i][1]);
                if(index < 0) index = 0;
                list.set(index, envelops[i][1]);
            }
        }
        return list.size();
    }
    private int binarySearch(ArrayList<Integer> list, int val) {
        int start = 0, end = list.size()-1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) >= val) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}