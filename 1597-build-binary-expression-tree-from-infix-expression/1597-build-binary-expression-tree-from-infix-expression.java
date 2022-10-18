/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        if(s==null || s.length()==0)
            return null;
        
        String postfix = convertToPostfixNotation(s);
        // System.out.println(s +" - "+postfix);
        return constructExpressionTree(postfix);
    }
    
    private Node constructExpressionTree(String s) {
        Stack<Node> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            Node newNode = new Node(ch);
            if(checkIfOperator(ch)) {
                newNode.right = stack.pop();
                newNode.left = stack.pop();
            }
            stack.push(newNode);
        }
        
        return stack.size() == 0 ? null : stack.peek();
    }
    
    private String convertToPostfixNotation(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            boolean isOperator = checkIfOperator(ch);
            if(isOperator) {
                int prec = getPrec(ch);
                while(!stack.isEmpty() && getPrec(stack.peek()) >= prec)
                    answer.append(stack.pop());
                stack.push(ch);
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') answer.append(stack.pop());
                stack.pop();
            } else answer.append(ch);
        }
        
        while(!stack.isEmpty()) answer.append(stack.pop());
        return answer.toString();
    }
    
    private boolean checkIfOperator(char ch) {
        switch(ch) {
            case '+':
            case '-':
            case '/':
            case '*': return true;
            default : return false;
        }
    }
    
    private int getPrec(char ch) {
        if(ch == '/' || ch == '*') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return 0;
    }
}