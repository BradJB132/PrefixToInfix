import java.util.Arrays;
import java.util.Stack;

public class Convertor {
    private static Stack<String> operationStack;
    private static Stack<Integer> numberStack;
    private static Stack<String> infixOpStack;
    private static Stack<String> infixNumStack;
    private static String[] express;

    private static String Evaluate(){
        int currStack = 0;

        for (String s : express) {
            if (Character.isDigit(s.charAt(0))) {
                numberStack.push(Integer.parseInt(s));
                currStack++;
            }
            else{
                operationStack.push(s);
                currStack = 0;
            }
            while(currStack >= 2 && numberStack.size() >= 2 && !operationStack.isEmpty()){
                int temp2 = numberStack.pop();
                int temp1 = numberStack.pop();
                int push;
                String charTemp = operationStack.pop();
                switch (charTemp) {
                    case "+" -> push = temp1 + temp2;
                    case "-" -> push = temp1 - temp2;
                    case "*" -> push = temp1 * temp2;
                    case "/" -> push = temp1 / temp2;
                    default -> {
                        return "error";
                    }
                }
                numberStack.push(push);
            }
        }
        return numberStack.pop().toString();
    }

    private static String convInfix() {
        StringBuilder infix = new StringBuilder();
        int currStack = 0;

        for (String s : express) {
            if (Character.isDigit(s.charAt(0))) {
                infixNumStack.push(s);
                currStack++;
            } else {
                infixOpStack.push(s);
                currStack = 0;
            }
            while (currStack >= 2 && infixNumStack.size() >= 2 && !infixOpStack.isEmpty()) {
                String temp2 = infixNumStack.pop();
                String temp1 = infixNumStack.pop();
                String charTemp = infixOpStack.pop();
                String push = "(" + temp1 + " " + charTemp + " " + temp2 + ")";
                infixNumStack.push(push);
            }
        }
        infix.append(infixNumStack.pop());
        infix.deleteCharAt(0);
        infix.deleteCharAt(infix.length()-1);
        return infix.toString();
    }
    public static void prefixToInfix(String Expression){

        operationStack = new Stack<>();
        numberStack = new Stack<>();
        infixOpStack = new Stack<>();
        infixNumStack = new Stack<>();

        express = Expression.split(" ");

        String eval = Evaluate();
        System.out.println(eval);
        String infix = convInfix();

        System.out.println(Expression + " -> " + infix + " = " + eval);
    }
}
