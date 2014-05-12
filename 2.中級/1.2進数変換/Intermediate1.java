package intermediate;

import java.util.Stack;

/**
 * 10進数の数を2進数に変換して返すクラス.
 *
 * @author a13509
 *
 */
public class Intermediate1 {

	/**
	 * 10進数を2進数の文字列に変換する.
	 * @param src 10進数の数値
	 * @return binaryString 2進数返還後の文字列
	 * @throws IllegalArgumentException
	 */
	public static String toBinaryString(int src) throws IllegalArgumentException {

		// 負の数が渡されるとIllegalArgumentExceptionを投げる
		if (src < 0) {
			throw new IllegalArgumentException();
		}

		// 0を渡されると0を返す
		if (src == 0) {
			return "0";
		}

		// 2進数定義
		final int BINARY_NUMBER = 2;

		// 10進数の数を2進数表記に変換する
		Stack<Integer> binaryNumberStack = new Stack<Integer>();
		while (src != 0) {
			binaryNumberStack.push(src % BINARY_NUMBER);
			src = src / BINARY_NUMBER;
		}

		String binaryString = "";
		while (!binaryNumberStack.empty()) {
			binaryString += binaryNumberStack.pop();
		}

		return binaryString;
	}
}
