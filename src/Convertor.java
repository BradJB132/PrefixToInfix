import java.util.Arrays;
import java.util.Stack;

public class Convertor {
    private static Stack<String> operationStack;
    private static Stack<Integer> numberStack;
    private static Stack<String> infixOpStack;
    private static Stack<Integer> infixNumStack;
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

    private static String convInfix(){
        StringBuilder infix = new StringBuilder();



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
        //String infix = convInfix();

        //System.out.println(Expression + " -> " + infix + " = " + eval);
    }
}
