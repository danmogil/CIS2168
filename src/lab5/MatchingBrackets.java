package lab5;

public class MatchingBrackets {
	public static String solution(String s) {
		MyStack<Character> brackets = new MyStack<>();
		MyStack<Integer> indexes = new MyStack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				brackets.push(c);
				indexes.push(i);
			} else if (c == ')' || c == '}' || c == ']') {
				if (c == ')') if (brackets.pop() != '(') return String.valueOf(i);
				if (c == '}') if (brackets.pop() != '{') return String.valueOf(i);
				if (c == ']') if (brackets.pop() != '[') return String.valueOf(i);
				indexes.pop();
			}
		}

		if (indexes.size() != 0) {
			while (indexes.size() > 1)
				indexes.pop();
			return String.valueOf(indexes.peek());
		}

		return "Success";
	}

	public static void main(String[] args) {
		System.out.println(solution("[]")); // Success
		System.out.println(solution("{}[]")); // Success
		System.out.println(solution("[()]")); // Success
		System.out.println(solution("foo(bar[i);")); // 9
		System.out.println(solution("{[]}()")); // Success
		System.out.println(solution("{")); // 0
		System.out.println(solution("{[}")); // 2
		System.out.println(solution("foo(bar);")); // Success
	}
}
