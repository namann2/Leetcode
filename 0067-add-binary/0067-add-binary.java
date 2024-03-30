class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        // 1 + 1 = 2 -> 10 -> 1 is carry and current is 0
        while(n > 0 || m > 0) {
            int c1 = n-1 >= 0 ? (a.charAt(n-1) == '1' ? 1 : 0) : 0;
            int c2 = m-1 >= 0 ? (b.charAt(m-1) == '1' ? 1 : 0) : 0;
            int sum = carry + c1 + c2;
            carry = sum / 2;
            answer.append(sum % 2);
            n--;
            m--;
        }
        if(carry != 0) answer.append(carry);
        return answer.reverse().toString();
    }
}