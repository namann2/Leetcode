[1,2,3,1]
if we are currently at i=3
1->0
2->1
3->2
now, 1 is already present in the hashmap means we would get an answer by checking the
condition that whether we are in valid window size or not.
1. If we are, return true
2. else, we are out of the valid window and so we will update the latest index in map
because the earlier mapping is out of the window and gping ahead it won't help us in the
answer (as it would still be out of the window) so we update the latest index in mapping
*/
// Way 1 :
// HashMap<Integer, Integer> map = new HashMap<>();
// for(int i=0;i<A.length;i++) {
//     if(!map.containsKey(A[i])) {
//         map.put(A[i], i);
//     } else {
//         if(i - map.get(A[i]) <= k) return true;
//         map.put(A[i], i);
//     }
// }
// return false;
// Way 2 : a bit clean
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < A.length; i++) {
if (map.containsKey(A[i])) {
if (i - map.get(A[i]) <= k) return true;
}
map.put(A[i], i);
}
return false;
}
}
```