class Solution {
    public long appealSum(String s) {
        long ans = 0;
        int[] seen = new int[26];
        Arrays.fill(seen, -1);
        int n = s.length();
        // contribution of character in all substrings ending at i
        for(int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            long curr = seen[ch] == -1 ? (i + 1) * (n - i) : (i - seen[ch]) * (n - i); 
            ans += curr;
            seen[ch] = i;
        }
        return ans;
    }
}