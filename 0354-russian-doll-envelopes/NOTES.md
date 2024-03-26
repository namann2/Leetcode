About sorting, <br>
    [[3,2],[3,2],[2,3],[2,2],[3,4],[3,6],[6,6]] <br>
            if we sort it like so,<br>
                </t> if(e1[0] == e2[0]) return e1[1] - e2[1];<br>
                </t> return e1[0] - e2[0];<br>

what issue is there ? 

Let's only write the height of our so called sorted array<br>
            2 3 2 2 4 6 6 <br>
            
in this case, 3 can allow 2 be put inside but in actual this is wrong, since the width of <br>
this envelope having h = 2, is same as that of envelope with h = 3. <br>
Hence, we want to keep the largest of height before to avoid this issue. 


<hr>

## Solution : 
Naive LIS solution won't work here, since the constraints are too high. We will use binary search + LIS

```
class Solution {
    public int maxEnvelopes(int[][] envelops) {
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
