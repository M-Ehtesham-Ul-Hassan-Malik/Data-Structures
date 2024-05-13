import java.util.Stack;

public class q5 {

    // Function to evaluate the postfix expression
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        postfix += ")"; // Step 1: Add ')' as sentinel

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (ch >= '0' && ch <= '9') { // Step 3: If operand is encountered, push onto stack
                stack.push(Character.getNumericValue(ch));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // Step 4: If operator is encountered
                // Step 4(a): Remove the top two elements from stack
                int t = stack.pop();
                int nt = stack.pop();

                // Step 4(b): Evaluate NT OP T and push the result onto stack
                switch (ch) {
                    case '+':
                        stack.push(nt + t);
                        break;
                    case '-':
                        stack.push(nt - t);
                        break;
                    case '*':
                        stack.push(nt * t);
                        break;
                    case '/':
                        stack.push(nt / t);
                        break;
                }
            }
        }

        // Step 5: Set value equal to the top element of stack
        int value = stack.peek();
        return value;
    }

    public static void main(String[] args) {
        String postfix = "32*5+"; // Example postfix expression: 3 * 2 + 5
        int result = evaluatePostfix(postfix);
        System.out.println("Value of postfix expression " + postfix + " is: " + result);
    }
}
