class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int left = 0, right = n-1;
        while(left < right) {
            if(ch[left] == ch[right]) {
                left ++;
                right --;
                while(ch[left] == ch[left-1] && left <= right) left++;
                while(ch[right] == ch[right+1] && right > left) right--;
            } else break;
        }
        return right - left + 1;
    }
}
