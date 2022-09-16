class Solution {
    public int uniqueLetterString(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();   
        // for the contributions on the left, and on the right
        int[]L = new int[n];
        int[]R = new int[n];
        
        int[] seen = new int[26];
        Arrays.fill(seen, -1);
        
        // contribution of char in all the substring ending at char
        for(int i = 0; i < n ; i ++) {
            char ch = s.charAt(i);
            int contribution = 0;
            if(seen[ch-'A'] != -1) {
                contribution = i - seen[ch-'A'];
            } else contribution = i+1;
            seen[ch-'A'] = i;
            L[i] = contribution;
        }
        
        Arrays.fill(seen, -1);
        // contribution of char in all the substring starting at char
        for(int i = n-1; i >= 0 ; i --) {
            char ch = s.charAt(i);
            int contribution = 0;
            if(seen[ch-'A'] != -1) {
                contribution = seen[ch-'A'] - i;
            } else contribution = n-i;
            seen[ch-'A'] = i;
            R[i] = contribution;
        }
        
        int cnt = 0;
        for(int i=0;i<n;i++)
            cnt += L[i] * R[i];
        
        return cnt;
    }
}


/*
    I need to find the count of unique chars in all the substrings of the given string.
    
    Thought 1 : 
    Lets consider all substring ending at particular position. If that is unique, the count would increment by 1 indicating the current char can be considered as a single length subsrting. What about the other substrings ending with this char ?
    We need to know the contribution of count of unique chars by all the substring before this, so we could use dp. We need to also have the index of current character if it has occured previously since, the contribution of substring after that would only be considered.
    
    Total contribution will be left * right
    
    1 1 1 1
    A B C A
    0 1 2 3
    
    A 
      B  C   A
      AB BC  CA
         ABC BCA
*/
