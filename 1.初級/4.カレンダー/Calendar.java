import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
  * カレンダー表示クラス.
  * 年と月を入力して、指定のカレンダーを表示する.
  *
  * @author Shota Sujino
  */
public class Calendar {

	/**
	 * メイン処理.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("カレンダーを出力します");


		// 「年」の入力
		System.out.println("年を入力してください（例：2014）");
		String input = inputString();

		// 正規表現の数値検出パターン
		String patternText = "^[0-9]+$";
		// 入力チェック
		if (!isMatching(input, patternText)) {
			System.out.println("数値の形式が正しくありません。");
			return;
		}

		// 入力された「年」を登録
		final int INPUT_YEAR = Integer.parseInt(input);


		// 「月」の入力
		System.out.println("月を入力してください（例：4）");
		input = inputString();

		// 正規表現の「月」検出パターン
		patternText = "[1-9]|1[0-2]";
		// 入力チェック
		if (!isMatching(input, patternText)) {
			System.out.println("数値の形式が正しくありません。");
			return;
		}

		// 入力された「月」を登録
		final int INPUT_MONTH = Integer.parseInt(input);


		// カレンダーの見出し
		System.out.println(INPUT_YEAR + "年" + INPUT_MONTH + "月のカレンダーを出力します");
		System.out.println(INPUT_YEAR + "年 " + INPUT_MONTH + "月");


		// カレンダーの設定
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(INPUT_YEAR, INPUT_MONTH - 1, 1);

		// カレンダー描画
		makeCalendar(calendar);
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
	 * 正規表現のパターンに一致するかを調べる.
	 * @param input 入力文字列
	 * @param patternText 正規表現のパターン
	 * @return ture or false
	 */
	private static boolean isMatching(String input, String patternText) {
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(input);

		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * カレンダーを作成する.
	 * 日付を文字列として保存し、最後に書き出す.
	 * 
	 * @param calendar 対象のカレンダー
	 */
	private static void makeCalendar(java.util.Calendar calendar) {
		System.out.println("日 月 火 水 木 金 土");

		// １日の曜日番号
		final int FIRST_WEEK_NUM = calendar.get(java.util.Calendar.DAY_OF_WEEK);
		// 月の最終日
		final int LAST_DATE = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		// １日の曜日まで空欄を入れる
		for (int i = 1; i < FIRST_WEEK_NUM; i++) {
			System.out.print("   ");
		}

		// 日付文字列
		String datesString = "";
		// 改行に用いる曜日番号
		int weekCount = FIRST_WEEK_NUM;

		for (int i = 1; i <= LAST_DATE; i++) {
			datesString += String.format("%2s", i);
			if (weekCount == 7 || i == LAST_DATE) {
				datesString += "\n";
				weekCount = 1;
			} else {
				datesString += " ";
				weekCount++;
			}
		}

		System.out.println(datesString);
	}
}
