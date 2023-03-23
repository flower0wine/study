package Algorithms.DataStructure.Stack;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 01 23:22
 * <p>
 * 逆波兰计算器(后缀表达式): 可以计算带括号的表达式，并考虑到运算符的优先级
 * 功能：只适用于加减乘除运算
 */
public class SuffixExpression {

    String suffixExpression;
    Stack<Integer> operatorStack;

    public SuffixExpression(String infixExpression) {
        if (this.bracketCorrespondence(infixExpression)) {
            throw new RuntimeException("括号不对应");
        }
        this.suffixExpression = infixToSuffix(infixExpression);
        operatorStack = new Stack<>();
    }

    // 判断括号是否对应
    private boolean bracketCorrespondence(String infixExpression) {
        char[] chars = infixExpression.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case '(' -> {
                    characterStack.push('(');
                }
                case ')' -> {
                    if (characterStack.pop() == null) {
                        throw new RuntimeException("括号不对应");
                    }
                }
            }
        }
        return !characterStack.isNull();
    }

    // 计算逆波兰表达式
    public int calcSuffixExpression() {
        String[] ele = this.suffixExpression.split("\s");
        for (String s : ele) {
            char c = s.charAt(0);
            if (isNumber(c)) {
                operatorStack.push(Integer.parseInt(s));
            } else if (isOperand(c)) {
                int num1 = operatorStack.pop();
                int num2 = operatorStack.pop();
                switch (c) {
                    case '+' -> {
                        operatorStack.push(num2 + num1);
                    }
                    case '-' -> {
                        operatorStack.push(num2 - num1);
                    }
                    case '*' -> {
                        operatorStack.push(num2 * num1);
                    }
                    case '/' -> {
                        operatorStack.push(num2 / num1);
                    }
                }
            }
        }
        return operatorStack.pop();
    }

    // 计算逆波兰表达式
    public int calcSuffixExpression(String infixExpression) {
        if (this.bracketCorrespondence(infixExpression)) {
            throw new RuntimeException("括号不对应");
        }
        this.suffixExpression = this.infixToSuffix(infixExpression);
        this.operatorStack = new Stack<>();
        return this.calcSuffixExpression();
    }

    // 将中缀表达式转为后缀表达式
    private String infixToSuffix(String infixExpression) {
        // stringBuilder 存储后缀表达式, number 存储数字
        StringBuilder stringBuilder = new StringBuilder(), number = new StringBuilder();
        char[] chars = infixExpression.toCharArray();
        Stack<String> middleStack = new Stack<>();  // 中间栈
        Stack<String> operatorStack = new Stack<>(); // 存储数字
        int j = 0;  // 数组下标
        while (j != chars.length) {
            char c = chars[j];
            if (isNumber(c)) { // 如果是数字, 多位数处理
                if (j == chars.length - 1) {    // 如果是数组最后一个数字
                    operatorStack.push(number.toString() + c);  // 拼接后存入数字栈
                } else {
                    number.append(c);
                }
            } else if (isOperand(c)) {  // 如果是符号
                if (!"".equals("" + number)) {  // 如果有数字就加入栈
                    operatorStack.push(number.toString());
                    number.delete(0, number.length());
                }
                if (!middleStack.isNull()) {    // 中间栈是否有符号
                    char s = middleStack.pop().charAt(0);
                    if (isOperand(s)) { // 如果是运算符, 比较运算符优先级
                        if (operandPriority(c, s) == 1) {
                            middleStack.push("" + s).push("" + c);
                        } else {
                            middleStack.push("" + c).push("" + s);
                        }
                    } else if ("(".equals("" + s)) {    // 如果是左括号, 直接将运算符入栈
                        middleStack.push("" + s).push("" + c);
                    }
                } else {    // 中间栈为空, 直接加入栈
                    middleStack.push("" + c);
                }
            } else if (c == '(') {  // 如果是左括号, 直接将括号入中间栈
                middleStack.push("" + c);
            } else if (c == ')') {  // 如果是右括号
                if (!"".equals("" + number)) {  // 将括号前的数字存入数字栈
                    operatorStack.push(number.toString());
                    number.delete(0, number.length());
                }
                while (!operatorStack.isNull()) {   // 如果数字栈不为空, 则将数字全部存入中间栈
                    middleStack.push(operatorStack.pop());
                }
                String pop = middleStack.pop();
                boolean flag = true;
                while (!middleStack.isNull()) {     // 如果中间栈不为空, 将内容全部拼接在 stringBuilder 中
                    if (!"(".equals(pop)) {
                        stringBuilder.append(pop).append(" ");
                    } else {
                        flag = false;   // 确保只在一个括号中进行
                    }
                    pop = middleStack.pop();
                    if (!flag) {  // 遇到左括号, 跳出循环
                        break;
                    }
                }
                if (!"(".equals(pop)) {     // 最后一个元素如果不是左括号
                    stringBuilder.append(pop).append(" ");
                }
            }
            j++;
        }
        // 清空数字栈
        while (!operatorStack.isNull()) {
            middleStack.push(operatorStack.pop());
        }
        while (!middleStack.isNull()) {
            stringBuilder.append(middleStack.pop()).append(" ");
        }
        return stringBuilder.toString();
    }

    // 更高效的中缀转后缀
    private void efficientInfixToSuffix(String infixExpression) {
        char[] chars = infixExpression.toCharArray();
        Stack<String> operandStack = new Stack<>();
        Stack<String> middleStack = new Stack<>();
        for (char c : chars) {
            if (isNumber(c)) {
                middleStack.push("" + c);
            } else if (isOperand(c)) {
                if(operandStack.isNull()){
                    operandStack.push("" + c);
                } else {
                    String s = operandStack.pop();
                    if ("(".equals(s)) {
                        operandStack.push(s).push("" + c);
                    } else if (operandPriority(s.charAt(0), c) == 1) {
                        middleStack.push(s);
                        operandStack.push("" + c);
                    } else if (operandPriority(s.charAt(0), c) == -1) {
                        middleStack.push("" + c);
                    }
                }
            } else if (c == '(') {
                operandStack.push("" + c);
            } else if (c == ')') {
                String pop = operandStack.pop();
                while (!"(".equals(pop)) {
                    middleStack.push(pop);
                    pop = operandStack.pop();
                }
            }
        }
        while (!operandStack.isNull()){
            middleStack.push(operandStack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!middleStack.isNull()){
            operandStack.push(middleStack.pop());
        }
        while (!operandStack.isNull()){
            stringBuilder.append(operandStack.pop());
        }
        System.out.println(stringBuilder);
    }

    // 判断是否是数字
    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    // 判断是否是运算符
    private boolean isOperand(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // 比较 a、b 两个操作符的优先级，-1 为 a 小于 b, 1 为 a 大于 b
    private int operandPriority(char a, char b) {
        switch (a) {
            case '+', '-' -> {
                if (b == '*' || b == '/') {
                    return -1;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        SuffixExpression suffixExpression = new SuffixExpression("(30 + 15 * 70) + 60");
        System.out.println(suffixExpression.calcSuffixExpression());
        System.out.println(suffixExpression.calcSuffixExpression("4 + (2 + 1) - 2"));
        System.out.println(suffixExpression.calcSuffixExpression("4 * (2 * (3 / (5 - 2) + 1)) - 2"));
        System.out.println(suffixExpression.calcSuffixExpression("1+((2+3)*4)-5"));


        suffixExpression.efficientInfixToSuffix("1+2*3*4-5");
    }
}
