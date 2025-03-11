class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIPAddress(s, 0, s.length(), new ArrayList<>(), result);
        return result;
    }

    private void restoreIPAddress(String s, int startIndex, int n, List<String> temp, List<String> result) {
        // base case
        if(temp.size() > 4) return;
        if(startIndex >= n && temp.size() == 4) {
            result.add(String.join(".", temp));
            return;
        }
        // main logic
        for(int i = 0; i < 3; i++) {
            int endIndex = startIndex + i + 1;
            if(endIndex > n) continue;
            String curr = s.substring(startIndex, endIndex);
            if(isValid(curr)) {
                temp.add(curr);
                restoreIPAddress(s, endIndex, n, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isValid(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        if(s.length() > 3) return false;
        if(Integer.valueOf(s) > 255) return false;
        return true;
    }
}