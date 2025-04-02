class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> validIPAddress = new ArrayList<>();
        if(n == 0 || s == null) return validIPAddress;
        restoreAddress(s, 0, s.length(), new ArrayList<>(), validIPAddress);
        return validIPAddress;
    }

    private void restoreAddress(String s, int start, int n, List<String> temp, List<String> validIPAddress) {
        // base case
        if(start >= n && temp.size() == 4) {
            String address = String.join(".", temp);
            validIPAddress.add(address);
            return;
        }
        // main logic
        for(int i = 0; i < 3; i++) {
            if(start + i >= n) return;
            String substring = s.substring(start, start + i + 1);
            if(isValid(substring)) {
                temp.add(substring);
                restoreAddress(s, start + i + 1, n, temp, validIPAddress);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isValid(String s) {
        int value = Integer.valueOf(s);
        if(value > 255) return false;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        return true;
    }
}