class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0)
            return logs;
        // TC : O(nk log n), n is the number of logs, k is the average length of the strings 
        // SC : O()
        Arrays.sort(logs, (l1, l2) -> {
            int idx1 = l1.indexOf(" ");
            int idx2 = l2.indexOf(" ");
            
            String iden1 = l1.substring(0, idx1);
            String iden2 = l2.substring(0, idx2);
            
            String data1 = l1.substring(idx1+1);
            String data2 = l2.substring(idx2+1);
            
            boolean isLetterLog1 = Character.isLetter(data1.charAt(0));
            boolean isLetterLog2 = Character.isLetter(data2.charAt(0));
            
            if(isLetterLog1 && isLetterLog2) {
                if(data1.compareTo(data2) == 0) return iden1.compareTo(iden2);
                return data1.compareTo(data2);
            }
            else if(isLetterLog1) { // log2 is a digit log
                return -1;
            } else if(isLetterLog2) { // log1 is a digit log
                return 1;
            }
            else return 0;
        });
        
        return logs;
    }
}