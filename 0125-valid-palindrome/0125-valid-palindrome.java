class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left <= right) {
            char LEFT = s.charAt(left);
            char RIGHT = s.charAt(right);
            
            if(!Character.isLetterOrDigit(LEFT)) left++;
            else if(!Character.isLetterOrDigit(RIGHT)) right--;
            else {
                if(Character.toLowerCase(LEFT) != Character.toLowerCase(RIGHT))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}