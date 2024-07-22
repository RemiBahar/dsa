package data_structures.stacks;

import java.util.Stack;

public class InfixEvaluator {
    private static final String OPERANDS = "+/*-";

    public static boolean isNumeric(String str){
        for(Character character : str.toCharArray()){
            if(!Character.isDigit(character)){
                return false;
            }
        }

        return true;
    }

    public static Integer calculate(Integer num1, Integer num2, String operator){
        if(operator.equals("+")){
            return num1 + num2;
        } else if(operator.equals("-")){
            return num1 - num2;
        } else if(operator.equals("/")){
            return num1 / num2;
        } else if(operator.equals("*")){
            return num1 * num2;
        } else {
            return null;
        }
    }

    /**
     * Assume space delimited
     * @param exp
     * @return
     */
    private static Integer calculate(String exp){
        String[] elements = exp.split(" ");
        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        for(String element : elements){
            if(isNumeric(element)){
                System.out.println("Adding to operands " + element);
                operands.push(Integer.parseInt(element));
            } else if(OPERANDS.contains(element)){
                System.out.println("Adding to operators " + element);
                operators.push(element);
            } else if(element.equals(")")){
                Integer num1 = operands.pop();
                Integer num2 = operands.pop();

                String operator = operators.pop();
                System.out.println(String.format("Calculating %s %s %s", num1, operator, num2));

                operands.push(calculate(num1, num2, operator));
            } else {
                System.out.println("Skipping element " + element);
            }
        }

        return operands.firstElement();
    }

    public static void main(String[] args){
        String exp = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";


        Integer returnValue = calculate(exp);

        System.out.println("Return Value is " + returnValue);
    }
}
