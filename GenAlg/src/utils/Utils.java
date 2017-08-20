package utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
	static int min = 0;
	static int max = 127;

	public static int[] charToAscii(char[] charArr) {
		int arrSize = charArr.length;
		int[] intArr = new int[arrSize];

		for (int i = 0; i < arrSize; i++) {
			intArr[i] = (int) charArr[i];
		}
		return intArr;
	}

	public static char[] AsciiTochar(int[] intArr) {
		int arrSize = intArr.length;
		char[] charArr = new char[arrSize];

		for (int i = 0; i < arrSize; i++) {
			charArr[i] = (char) intArr[i];
		}
		return charArr;
	}

	public static int RandomNumberGen() {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static int[] AnswerRepresentation(String sent) {
		char[] charArr = sent.toCharArray();
//		System.out.println("Answer is: " + Arrays.toString(Utils.charToAscii(charArr)));
		return Utils.charToAscii(charArr);
	}

}
