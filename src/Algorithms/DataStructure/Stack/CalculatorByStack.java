package Algorithms.DataStructure.Stack;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 09 30 13:41
 * <p>
 * 由双栈实现的计算器
 */
public class CalculatorByStack {
    private char[] calc;
    private Stack<Integer> operatorStack;
    private Stack<Character> operandStack;

    public CalculatorByStack() {
    }

    public CalculatorByStack(String calc) {
        this.calc = calc.toCharArray();
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
        this.pushStack();
    }

    // 对输入的表达式进行压栈
    private void pushStack() {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < calc.length; i++) {
            char temp = calc[i];
            if (isOperator(temp)) {
                operandStack.push(temp);
                operatorStack.push(Integer.parseInt(num.toString()));
                num.delete(0, num.length());
            } else if(isNumber(temp)) {
                num.append(temp);
            }
        }
        operatorStack.push(Integer.parseInt(num.toString()));
    }

    // 判断是否是数字
    private boolean isNumber(char c){
        return c <= 58 && c >= 48;
    }

    // 判断是否是运算符
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // 计算结果
    public int calcResult() {
        while (!operandStack.isNull()) {
            char op1 = operandStack.pop();
            int num1 = operatorStack.pop();
            int num2 = operatorStack.pop();
            switch (op1) {
                case '*': {
                    operatorStack.push(num1 * num2);
                    break;
                }
                case '/': {
                    operatorStack.push(num2 / num1);
                    break;
                }
                case '+': {
                    Character op2 = operandStack.pop();
                    if (op2 == null) {
                        return num1 + num2;
                    }
                    switch (op2) {
                        case '*': {
                            int num3 = operatorStack.pop();
                            operatorStack.push(num2 * num3).push(num1);
                            operandStack.push('+');
                            break;
                        }
                        case '/': {
                            int num3 = operatorStack.pop();
                            operatorStack.push(num3 / num2).push(num1);
                            operandStack.push('+');
                            break;
                        }
                        case '+':
                        case '-': {
                            operatorStack.push(num1 + num2);
                            operandStack.push(op2);
                            break;
                        }
                    }
                    break;
                }
                case '-': {
                    Character op2 = operandStack.pop();
                    if (op2 == null) {
                        return num2 - num1;
                    }
                    switch (op2) {
                        case '*': {
                            int num3 = operatorStack.pop();
                            operatorStack.push(num2 * num3).push(num1);
                            operandStack.push('+');
                            break;
                        }
                        case '/': {
                            int num3 = operatorStack.pop();
                            operatorStack.push(num3 / num2).push(num1);
                            operandStack.push('+');
                            break;
                        }
                        case '+':
                        case '-': {
                            operatorStack.push(num2 - num1);
                            operandStack.push(op2);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return operatorStack.pop();
    }

    public int calcResult(String calc) {
        this.calc = calc.toCharArray();
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
        this.pushStack();
        return this.calcResult();
    }


    public static void main(String[] args) {
        CalculatorByStack calculatorByStack = new CalculatorByStack("100 - 1 * 100");
        System.out.println(calculatorByStack.calcResult());
        System.out.println(calculatorByStack.calcResult("3 / 3 + 1 + 1"));
    }
}
