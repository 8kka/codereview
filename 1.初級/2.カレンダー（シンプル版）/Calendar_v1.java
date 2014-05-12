import java.util.Calendar;

/**
  * カレンダー表示クラス.
  * 現在時刻から、今月のカレンダーを表示する.
  *
  * @author Shota Sujino
  */
public class Calendar_v1 {

	/**
	 * メイン処理.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// カレンダー作成
		Calendar calendar = Calendar.getInstance();

		// カレンダーのタイトルを表示
		drawTitle(calendar);

		// 曜日の定義
		final char[] WEEK_NAME = {'日', '月', '火', '水', '木', '金', '土'};

		// 曜日を表示
		drawWeeks(WEEK_NAME);

		// 日付配列作成
		// 行列整形のため、文字列として保存しておく
		final String[] DATES = makeDates(calendar);

		// 日付を表示
		drawDates(calendar, WEEK_NAME.length, DATES);

	}


	/**
	 * カレンダーのタイトル表示.
	 * カレンダーの「年」と「月」を取得して表示させる.
	 *
	 * @param calendar 今日の日付設定のカレンダー
	 */
	private static void drawTitle(Calendar calendar) {
		// 今年と今月の数値を取得
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH) + 1;

		System.out.println(nowYear + "年" + nowMonth + "月のカレンダーを出力します");
		System.out.println(nowYear + "年 " + nowMonth + "月");
	}


	/**
	 * 曜日一覧を表示.
	 * 指定の曜日名を横一列に表示させる.
	 *
	 * @param weekName 表示させたい曜日名の配列
	 */
	private static void drawWeeks(char[] weekName) {
		for (int i = 0; i < weekName.length; i++) {
			System.out.print(weekName[i] + " ");
		}
		System.out.println();
	}


	/**
	 * 日付配列作成.
	 * 指定の月の日付をString配列で記録する.
	 * 今回のプログラムでは、「今月」が対象になる.
	 *
	 * @param calendar 今日の日付設定のカレンダー
	 * @return dates 日付の文字列配列
	 */
	private static String[] makeDates(Calendar calendar) {
		// 最終日を定義する
		final int LAST_DATE = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 段落下げをする配列番号
		final int INDENT_ARRAY_NUM = 9;
		// 日付配列
		String[] dates = new String[LAST_DATE];

		// 1桁の日付は直前にスペースを入れる
		for (int i = 0; i < dates.length; i++) {
			if (i < INDENT_ARRAY_NUM) {
				dates[i] = " " + (i + 1);
			} else {
				dates[i] = Integer.toString(i + 1);
			}
		}

		return dates;
	}


	/**
	 * 日付を表示する.
	 * 1段目と2段目以降に分けて処理を行う.
	 * 
	 * @param calendar 今日の日付設定のカレンダー
	 * @param weekLength 曜日の数
	 * @param dates 日付の文字列配列
	 */
	private static void drawDates(Calendar calendar, int weekLength, String[] dates) {
		// 今月１日の曜日番号取得
		calendar.set(Calendar.DATE, 1);
		final int FIRST_WEEK_NUM = calendar.get(Calendar.DAY_OF_WEEK);
		// datesの配列番号
		int dayNum = 0;

		// 1段目の日付
		for (int i = 1; i <= weekLength; i++) {
			if (i < FIRST_WEEK_NUM) {
				System.out.print("   ");
			} else {
				System.out.print(dates[dayNum] + " ");
				dayNum++;
			}
		}
		System.out.println();

		// 改行の目安番号
		int changeRowNum = dayNum;
		// 値が7以上の場合は初期化
		if (changeRowNum >= weekLength) {
			changeRowNum = 0;
		}

		// 2段目以降の日付
		while (dayNum < dates.length) {
			System.out.print(dates[dayNum] + " ");
			dayNum++;
			if (dayNum % weekLength == changeRowNum) {
				System.out.println();
			}
		}
	}

}