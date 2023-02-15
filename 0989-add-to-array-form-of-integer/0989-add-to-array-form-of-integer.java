class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<>();
        int carry = 0, n = num.length-1;
        while(n >= 0 || k > 0) {
            int csum = carry;
            if(n >= 0) csum += num[n];
            if(k >= 0) csum += k % 10;
            n--;
            k /= 10;
            carry = csum / 10;
            answer.add(csum % 10);
        }
        if(carry != 0) answer.add(carry);
        Collections.reverse(answer);
        return answer;
    }
}