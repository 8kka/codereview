import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Eratosthenes {
	
	public static void main(String[] args) {

		// 説明文
		System.out.println("素数リストを出力するプログラムです。");
		System.out.println("リストの最大値を整数で入力してください。");

		// 最大値入力
		String inputMaxNum = inputString();

		// 数値チェック
		if (!isInteger(inputMaxNum)) {
			System.out.println("不正な値が入力されました。");
			return;
		}

		// 数値変換
		int maxNum = Integer.parseInt(inputMaxNum);

		// 自然数チェック
		if (!isNaturalNum(maxNum)) {
			System.out.println("自然数を入力してください。");
			return;
		}

		// 探索リスト
		LinkedList<Integer> searchList = new LinkedList<Integer>();
		// 素数リスト
		LinkedList<Integer> primeList = new LinkedList<Integer>();

		// 探索リストに値を入れる
		for (int i = 2; i <= maxNum; i++) {
			searchList.add(i);
		}

		// 篩い落とし
		sieveMultipleNum(maxNum, searchList, primeList);

		// 探索リストに残った数を素数リストに移動
		for (int i = 0; i < searchList.size(); i++) {
			primeList.add(searchList.get(i));
		}

		// 描画
		for (int i = 0; i < primeList.size(); i++) {			
			System.out.print(primeList.get(i) + " ");
		}
		
	}


	/**
	 * 入力処理.
	 * @return 入力された文字列
	 */
	private static String inputString() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = bReader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}

		return input;
	}


	/**
	 * 数値チェック.
	 * 文字列がint型に変換できるかを調べる.
	 * @param input 入力文字列
	 * @param true：int変換可 false：int変換不可
	 */
	private static boolean isInteger(String inputMaxNum) {
		try {
			Integer.parseInt(inputMaxNum);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 自然数チェック.
	 * 数値が自然数をを調べる.
	 * @param maxNum 入力数値
	 * @return true：自然数 false：自然数以外
	 */
	private static boolean isNaturalNum(int maxNum) {
		if (maxNum < 0) {
			return false;
		} else {
			return true;
		}
	}


	/**
	 * 倍数判定.
	 * @param firstNum 探索リストの先頭の数字
	 * @param listNum 探索リストの指定数値
	 * @return true：倍数 false：倍数以外
	 */
	private static boolean isMultiple(int firstNum, int listNum) {
		if (listNum % firstNum == 0) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 探索リストの先頭値が、最大値の平方根に達しているかを調べる.
	 * @param maxNum 最大値
	 * @param firstNum 探索リストの先頭値
	 * @param true or false
	 */
	private static boolean isSquareRoot(int maxNum, int firstNum) {
		if (Math.sqrt(maxNum) > firstNum) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 篩い落とし.
	 * 探索リストの先頭の数を素数リストに移動し、その倍数を探索リストから篩い落とす.
	 * 探索リストの先頭値が最大値の平方根に達するまで行う.
	 * @param manNum 最大値
	 * @param searchList 探索リスト
	 * @param primeList 素数リスト
	 */
	private static void sieveMultipleNum(int maxNum, LinkedList<Integer> searchList, LinkedList<Integer> primeList) {
		// 探索リストの先頭値
		int firstNum = 0;

		// 篩い落とし
		while(isSquareRoot(maxNum, firstNum) && searchList.size() > 0) {
			// 先頭値をリストに入れる
			firstNum = searchList.remove();
			primeList.add(firstNum);

			// 倍数を削除
			for (int i = 0; i < searchList.size(); i++) {
				if (isMultiple(firstNum, searchList.get(i))) {
					searchList.remove(i);
				}
			}
		}
	}

}
