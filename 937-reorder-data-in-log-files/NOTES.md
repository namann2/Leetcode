```
class Solution {
    /*
        Let N be the number of logs in the list and M be the maximum length of a single log.
        Time Complexity: O(M⋅N⋅logN)
        Space Complexity : O(N)
        
        1. First of all, the time complexity of the Arrays.sort() is O(N⋅logN), 
            which is to say that the compare() function would be invoked O(N⋅logN) times.
        2. For each invocation of the compare() function, it could take up to O(M) time, 
            since we compare the contents of the logs.
    */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2)->{
            int i1 = l1.indexOf(" ");
            int i2 = l2.indexOf(" ");
            
            String id1 = l1.substring(0,i1);
            String id2 = l2.substring(0,i2);
            
            String logdata1 = l1.substring(i1+1);
            String logdata2 = l2.substring(i2+1);
            
            boolean isLetterLog1 = Character.isAlphabetic(logdata1.charAt(0));
            boolean isLetterLog2 = Character.isAlphabetic(logdata2.charAt(0));
            
            // both the data are letter logs
            if(isLetterLog1 && isLetterLog2) {
                if(logdata1.compareTo(logdata2) == 0)
                    return id1.compareTo(id2);
                return logdata1.compareTo(logdata2);
            }
            
            // both the data are digit logs
            if(!isLetterLog1 && !isLetterLog2) {
                return 0;
            }
            
            if(isLetterLog1) return -1;
            return 1;
        });
        
        return logs;
    }
}
```
