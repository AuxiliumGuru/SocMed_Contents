package calculator_GUI;

import java.util.Scanner;
import java.util.Stack;

public class Stack_Calculator {

	/*
	 * Error documentation:
	 * 		1. The earlier version of the code doesn't recognize negative numbers, specifically
	 * 	at the execution of the getResult() function of postfix.
	 * 
	 * 		2. The earlier version of the code doesn't support more than three operations because of the 
	 * 	spacing. Ex. 5+5+5 -> 5 5 +5+ The desired output must be -> 5 5+ 5+
	 * 
	 * Solution:
	 * 		1. At the case of "-" of the switch statement, verify first if the next char is digit. If so, 
	 * 	concatenate the current index and the next char and then convert it to integer using parseInt(int). 
	 * 	Then, increment the for loop and break the current iteration to move onto the next one.
	 * 		2. As as solution, before popping the precedence operators, delete first the last char of the
	 * 	postfix because it is expected that it is a "space" character, then append the popped operator
	 * 	concatenating another space as a regEx.
	 */
	
	Stack<Double> stack = new Stack<Double>();
	final static Scanner input = new Scanner(System.in);


	public static int getPrecedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	public static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	}

	public static boolean isNegativeNumber(String s, int i) {
		if (i == 0) {
			return false;
		}
		char prevChar = s.charAt(i - 1);
		return (prevChar == '(' || isOperator(prevChar));
	}

	public String infixToPostfix(String infix) {
		Stack<Character> operatorStack = new Stack<>();
		StringBuilder postfix = new StringBuilder();

		String token = "";
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			// If the current character is a digit or a negative sign, append it to the output string
			if (Character.isDigit(c) || (c == '-' && isNegativeNumber(infix, i))
					|| c == '.') {	
				token += c;

			} else {
				// Append token to the postfix builder
				postfix.append(token + " ");
				token = "";
				switch (c) {
				case '(':
					// If the current character is an opening parenthesis, push it onto the stack
					operatorStack.push(c);
					break;
				case ')':
					// If the current character is a closing parenthesis, pop operators from the stack and append them to the output
					// string until an opening parenthesis is encountered (which is discarded)
					while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
						postfix.append(operatorStack.pop());
					}
					if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
						operatorStack.pop();
					}
				default:
					// If the current character is an operator, pop operators from the stack and append them to the output string
					// until an operator with lower precedence (or an opening parenthesis) is encountered
					
					while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
						postfix.deleteCharAt(postfix.length()-1);
						postfix.append(operatorStack.pop());
						postfix.append(" ");
					}
					operatorStack.push(c);

				}  
			}

			if (Character.isDigit(c) && i == infix.length()-1) {
				postfix.append(token);
			}

		}

		// Pop any remaining operators from the stack and append them to the output string
		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}

		return postfix.toString().trim();
	}

	public boolean hasDecimalValue(double num) {
		return (Double.toString(num).indexOf('.') == -1 || num % 1 == 0);
	}

	public void getStackValue(Stack<Double> stack) {
		double answer = stack.pop();
		if (hasDecimalValue(answer)) {
			System.out.printf("%.0f\n", answer);
			return;
		}
		System.out.printf("%.2f\n", answer);
	}
	public void getResult(String pf_expression) {
		if (!pf_expression.matches("[0-9 .+\\-*/]+")) {
			System.out.println("Invalid input string");
			return;
		}

		String token = "";
		for (int i = 0; i < pf_expression.length(); i++) {
			double a, b, result;

			//			if (Character.isDigit(pf_expression.charAt(i))) {
			//
			//				if (i < pf_expression.length() - 1 && Character.isDigit(pf_expression.charAt(i + 1))) {
			//					token.append(pf_expression.charAt(i));
			//					continue;
			//				} else {
			//					stack.push(Integer.parseInt(token.toString()));
			//					token.setLength(0);
			//				}
			//			}
			char c = pf_expression.charAt(i);
			if (Character.isDigit(c) || c == '.') {
				token += c;
			} else if (c == ' ') {
				if (!token.isEmpty()) {
					stack.push(Double.parseDouble(token));
					token = "";
				}
			} else {
				if (!(token.length() == 0)) {
					stack.push(Double.parseDouble(token));
					token = "";
				}
				switch (pf_expression.charAt(i)) {
				case '+':
					if (stack.size() < 2) {
						a = stack.pop();
						result = a;
						stack.push(result);
					} else {
						a = stack.pop();
						b = stack.pop();
						result = a + b;
						stack.push(result);
					}
					break;
				case '-':
					if (stack.size() < 2) {
						a = stack.pop();
						result = a;
						stack.push(result);
					} else {
						a = stack.pop();
						b = stack.pop();
						result = b - a;
						stack.push(result);
					}
					break;
				case '*':
					if (stack.size() < 2) {
						a = stack.pop();
						result = a;
						stack.push(result);
					} else {
						a = stack.pop();
						b = stack.pop();
						result = a * b;
						stack.push(result);
					}
					break;
				case '/':
					if (stack.size() < 2) {
						a = stack.pop();
						result = a;
						stack.push(result);
					} else {
						a = stack.pop();
						b = stack.pop();
						result = b / a;
						stack.push(result);
					}
					break;
				default:
					System.out.println("Invalid");

				}
			}

		}

	}
}