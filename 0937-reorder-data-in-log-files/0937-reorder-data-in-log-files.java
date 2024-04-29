/*
Let N be the number of logs in the list and M be the maximum length of a single log.

Time Complexity: O(M⋅N⋅logN)

First of all, the time complexity of the Arrays.sort() is 
O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked 
O(N⋅logN) times.

For each invocation of the compare() function, it could take up to 
O(M) time, since we compare the contents of the logs.

Therefore, the overall time complexity of the algorithm is 
O(M⋅N⋅logN).


Space Complexity: 
O(M⋅logN)

For each invocation of the compare() function, we would need up to 
O(M) space to hold the parsed logs.

In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is 
O(logn), assuming that the space for each element is O(1)). Since each log could be of O(M) space, we would need O(M⋅logN) space to hold the intermediate values for sorting.

In total, the overall space complexity of the algorithm is  O(M⋅logN).

*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new CustomComparator());
        return logs;
    }
}

class CustomComparator implements Comparator<String> {
    
    private static final String space = " ";
    
    @Override
    public int compare(String A, String B) {
        
        String[] l1 = A.split(space, 2);
        String[] l2 = B.split(space, 2);
        
        // identifier
        String id1 = l1[0];
        String id2 = l2[0];
        
        // data
        String d1 = l1[1];
        String d2 = l2[1];
        
        boolean isLetter1 = Character.isLetter(d1.charAt(0));
        boolean isLetter2 = Character.isLetter(d2.charAt(0));
        
        // both logs are digit logs
        if(!isLetter1 && !isLetter2) {
            return 0;
        } else if(isLetter1 && isLetter2) {
            if(d1.equals(d2)) return id1.compareTo(id2);
            return d1.compareTo(d2);
        } else {
            return isLetter1 ? -1 : 1;
        }
    }
}