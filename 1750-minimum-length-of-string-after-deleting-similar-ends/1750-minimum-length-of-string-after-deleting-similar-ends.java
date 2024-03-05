class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
                while(s.charAt(left) == s.charAt(left-1) && left <= right) left++;
                while(s.charAt(right) == s.charAt(right+1) && right > left) right--;
            } else break;
        }
        return right - left + 1;
    }
}
