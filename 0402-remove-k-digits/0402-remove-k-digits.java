class Solution {
    public String removeKdigits(String input, int k) {
        // edge case : k == input.length()
        int n = input.length();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.addLast(input.charAt(0)-'0');

        for(int i = 1; i < n; i++) {
          int curr = input.charAt(i) - '0';
          while(!stack.isEmpty() && k > 0 && stack.peekLast() > curr) {
            stack.removeLast();
            k--;
          }
          stack.addLast(curr);
        }

        // check whether k is zero or not : 
        while(!stack.isEmpty() && k > 0) {
          stack.removeLast();
          k--;
        }

        // iterate over the stack to remove leading zeros
        while(!stack.isEmpty() && stack.peekFirst() == 0) stack.removeFirst();
        
        if(stack.isEmpty()) return "0";
        
        StringBuilder smallestNumber = new StringBuilder();
        while(!stack.isEmpty()) {
          smallestNumber.append(stack.removeFirst());
        }
        
        return smallestNumber.toString();
    }
}
