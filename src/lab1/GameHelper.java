package lab1;

import java.util.Scanner;

public class GameHelper {

	private static Scanner sc = new Scanner(System.in);

	public static int getInput(String prompt) {
		System.out.print(prompt + ": ");
		return sc.nextInt();
	}
}
