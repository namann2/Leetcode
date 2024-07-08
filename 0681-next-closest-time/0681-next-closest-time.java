class Solution {
    public String nextClosestTime(String time) {
        String DEL = ":";
        
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);
        
        Set<String> allPossibleTime = new HashSet<>();
        // find all possible permutation of the string to find all possible times that can be created
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    for(int l = 0; l < 4; l++) {
                        String tempTime = new StringBuilder()
                                        .append(digits[i])
                                        .append(digits[j]).append(DEL)
                                        .append(digits[k])
                                        .append(digits[l]).toString();
                        if(isValidTime(tempTime)) {
                            allPossibleTime.add(tempTime);
                        }
                    }
                }
            }
        }
        
        List<String> uniqueTimes = new ArrayList<>(allPossibleTime);
        Collections.sort(uniqueTimes);
        int n = uniqueTimes.size();
        int index = uniqueTimes.indexOf(time);
        // return index + 1 == n ? uniqueTimes.get(0) : uniqueTimes.get((index + 1) % n);
        return uniqueTimes.get((index + 1) % n);
    }
    
    public boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}