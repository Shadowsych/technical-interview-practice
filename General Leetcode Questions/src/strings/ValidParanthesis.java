package strings;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(isValid("()(){}()({})"));
	}

	private static boolean isValid(String s) {
		// create a Stack that holds the open parenthesis
		Stack<Character> stack = new Stack<>();

		for(int charIndex = 0; charIndex < s.length(); charIndex++) {
			char paranthesis = s.charAt(charIndex);
			if(paranthesis == '(' || paranthesis == '{' || paranthesis == '[') {
				// push the open parenthesis to the Stack
				stack.push(paranthesis);
			} else if(paranthesis == ')' || paranthesis == '}' || paranthesis == ']') {
				if(stack.isEmpty()) {
					// empty Stack, yet we encountered a closing parenthesis
					return false;
				}
				char openParanthesis = stack.pop();

				// check if the most recent parenthesis was its corresponding closing parenthesis
				if((openParanthesis == '(' && paranthesis == ')')) {
					// it's valid so far
				} else if((openParanthesis == '{' && paranthesis == '}')) {
					// it's valid so far
				} else if((openParanthesis == '[' && paranthesis == ']')) {
					// it's valid so far
				} else {
					return false;
				}
			}
		}

		// if the Stack is empty, then all open parenthesis had a matching closing parenthesis
		return stack.isEmpty();
	}
}
