class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        restore(s, 0, s.length(), new ArrayList<>(), answer);
        return answer;
    }
    private void restore(String s, int index, int n, List<String> temp, List<String> answer) {
        // base case
        if(temp.size() > 4) return;
        
        if(index >= n && temp.size() == 4) {
            answer.add(String.join(".", temp));
            return;
        }
        // main logic
        for(int i = 1; i <= 3; i++) {
            if(index + i > n) continue;
            String prefix = s.substring(index, index + i);
            if(isValid(prefix)) {
                temp.add(prefix);
                restore(s, index+i, n, temp, answer);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isValid(String ip) {
        if(Integer.valueOf(ip) > 255 ||
          ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        }
        return true;
    }
}