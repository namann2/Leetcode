abstract class Node {
    public abstract int evaluate();
};

class TreeNode extends Node {
    String data;
    TreeNode left, right;
    
    TreeNode(String data) {
        this.data = data;
    }
    
    @Override
    public int evaluate() {
        return evaluateTree(this);
    }
    
    private int evaluateTree(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) 
            return Integer.valueOf(node.data);
        
        int left = evaluateTree(node.left);
        int right = evaluateTree(node.right);
        
        return compute(node.data, left, right);
    }
    
    private int compute(String op, int left, int right) {
        Operator oper = OperatorFactory.getOperator(op);
        return oper.execute(left, right);
    } 
}

class OperatorFactory {
    
    public static Operator getOperator(String type) {
        Operator operator = null;
        if(type.equals("+")) return new AdditionOperator();
        else if(type.equals("-")) return new SubtractionOperator();
        else if(type.equals("/")) return new DivisionOperator();
        else if(type.equals("*")) return new MultiplicationOperator();
        else return operator;
    }
    
}

interface Operator {
    int execute(int a, int b);
}

class AdditionOperator implements Operator {
    public int execute(int a, int b) {
        return a + b;
    }
}

class SubtractionOperator implements Operator {
    public int execute(int a, int b) {
        return a - b;
    }
}

class DivisionOperator implements Operator {
    public int execute(int a, int b) {
        return a / b;
    }
}

class MultiplicationOperator implements Operator {
    public int execute(int a, int b) {
        return a * b;
    }
}

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack<>();
        for(String curr : postfix) {
            TreeNode newNode = new TreeNode(curr);
            boolean isOperator = checkIfOperator(curr);
            if(isOperator) {
                TreeNode rightChild = stack.pop();
                TreeNode leftChild = stack.pop();
                newNode.left = leftChild;
                newNode.right = rightChild;
            }
            stack.push(newNode);
        }
        return stack.size() == 0 ? null : stack.pop();
    }
    
    private boolean checkIfOperator(String curr) {
        switch(curr) {
            case "+":
            case "-":
            case "/":
            case "*": return true;
                
            default : return false;
        }
    }
};