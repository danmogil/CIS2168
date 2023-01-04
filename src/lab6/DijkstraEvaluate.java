package lab6;

import java.util.Scanner;
import java.util.Stack;

public class DijkstraEvaluate {

	public static double includeSQRT(Scanner sc) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();

		while (sc.hasNext()) {
			String s = sc.next();
			if (s.equals("("));
			else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v += vals.pop();
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v *= vals.pop();
				else if (op.equals("/")) v = vals.pop() / v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			} else vals.push(Double.parseDouble(s));
		}

		return vals.pop();
	}

	public static double original(Scanner sc) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();

		while (sc.hasNext()) {
			String s = sc.next();
			if (s.equals("("));
			else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op == "+") v += vals.pop();
				else if (op == "-") v -= vals.pop();
				else if (op == "*") v *= vals.pop();
				else if (op == "/") v /= vals.pop();
			} else vals.push(Double.parseDouble(s));
		}

		return vals.pop();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner("( 1 + ( sqrt ( 4.0 ) / 2.0 ) )");
		System.out.print(includeSQRT(sc));
	}

}
