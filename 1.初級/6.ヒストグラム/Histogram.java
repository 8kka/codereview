import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * ヒストグラムを表示するクラス.
 * 実行時の引数に応じて「*」を表示する.
 * 数値が大きいほど高いヒストグラムを表示する.
 *
 * @author Shota Sujino
 */
public class Histogram {
	
	/**
	 * メイン処理.
	 * @param args ヒストグラムの引数
	 */
	public static void main(String[] args) {

		// argsに値がない場合
		if (args.length < 1) {
			System.out.println("グラフにプロットする値を引数に指定してください。");
			System.out.println("例）java Histogram 1 2 3 3 2 1");
			return;
		}

		// 入力文字列チェック
		for (int i = 0; i < args.length; i++) {
			// 数値チェック
			if (!isInteger(args[i])) {
				System.out.println("引数に指定できるのは数値のみです。");
				return;
			}

			// 負数チェック
			if (!isNaturalNum(args[i])) {
				System.out.println("引数に指定できるのは正の数だけです。");
				return;
			}
		}

		// 配列をint型に変換する
		int[] inputNumArray = toIntArray(args);

		// 最大値を求める
		int maxNum = findMaxNum(inputNumArray);

		// ヒストグラムを描画する
		drawHistogram(maxNum, inputNumArray);
	}


	
	/**
	 * 数値チェック.
	 * 文字列がint型に変換できるかを調べる.
	 * @param str 調査する文字列
	 * @param true：int変換可 false：int変換不可
	 */
	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	/**
	 * 自然数チェック.
	 * 文字列が自然数かを調べる.
	 * @param str 調査する文字列
	 * @return ture：自然数 false：自然数以外
	 */
	private static boolean isNaturalNum(String str) {
		Pattern pattern = Pattern.compile("^-");
		Matcher matcher = pattern.matcher(str);

		if (!matcher.find()) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * String配列をint配列に変換する.
	 * @param strArray 変換する文字列配列
	 * @return intArray int変換後の配列
	 */
	private static int[] toIntArray(String[] strArray) {
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}

		return intArray;
	}


	/**
	 * 配列内の最大値を調べる.
	 * @param numArray 検索対象の数値配列
	 * @return maxNum 配列内の最大数値
	 */
	private static int findMaxNum(int[] numArray) {
		int maxNum = 0;
		for (int i = 0; i < numArray.length; i++) {
			if (maxNum < numArray[i]) {
				maxNum = numArray[i];
			}
		}

		return maxNum;
	}


	/**
	 * ヒストグラムを描画する.
	 * 与えられた引数の数に応じて、縦に*を描画する.
	 * @param maxNum 配列内の最大数値
	 * @param numArray ヒストグラムの数値を表す引数
	 */
	private static void drawHistogram(int maxNum, int[] numArray) {
		for (int i = maxNum - 1; i >= 0; i--) {
			for (int j = 0; j < numArray.length; j++) {
				// 現在の要素がiより大きい場合、*を描画する
				if (numArray[j] > i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
