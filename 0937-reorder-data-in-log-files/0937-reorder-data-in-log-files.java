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