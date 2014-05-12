import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * じゃんけんクラス。<br>
 * プレイヤーとコンピュータで対戦をする。<br>
 * プレイヤーは1~3の数字を入力して自分の手を選択する。<br>
 * あいこ、または正しい入力がされなかった場合は処理を繰り返す。
 *
 * @author Sujino_Shota
 */
public class RPS {

	/**
	 * じゃんけんの結果を表す列挙型。
	 *
	 * @author a13509
	 */
	public enum Result {
		/** 初期状態。 */
		NONE(""),
		/** あいこ。 */
		DRAW("あいこです！"),
		/** 負け。 */
		LOSS("あなたの負けです！"),
		/** 勝ち。 */
		WIN("あなたの勝ちです！");

		/** 結果に対するメッセージ。 */
		private final String message;

		/**
		 * Resultのコンストラクタ。<br>
		 * 結果に対するメッセージを引数に持つ。
		 * @param message 結果に対するメッセージ
		 */
		private Result(String message) {
			this.message = message;
		}

		/**
		 * 結果に対するメッセージを返す。
		 * @return 対象のメッセージ
		 */
		@Override
		public String toString() {
			return this.message;
		}
	}

	/**
	 * じゃんけんの手を表す列挙型。
	 *
	 * @author a13509
	 */
	public enum Hand {
		/** 初期状態。 */
		NONE(""),
		/** グー。 */
		ROCK("グー"),
		/** チョキ。 */
		SCISSORS("チョキ"),
		/** パー。 */
		PAPER("パー");

		/** 表記。 */
		private final String name;

		/**
		 * Handのコンストラクタ。<br>
		 * 表記文字列を引数に持つ。
		 * @param name 手に対する表記文字列
		 */
		private Hand(String name) {
			this.name = name;
		}

		/**
		 * 手に対する表記の文字列を返す。
		 * @return 表記文字列
		 */
		@Override
		public String toString() {
			return this.name;
		}
	}

	/**
	 * じゃんけんのメイン処理。
	 * @param args 今回は使用しない
	 */
	public static void main(String[] args) {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		Random random = new Random();

		// プレイヤーの入力可能文字のパターン
		Pattern pattern = Pattern.compile("[123１２３]");

		// 勝敗の初期化
		Result result = Result.NONE;

		// ゲーム開始時のメッセージ
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー");

		// じゃんけんの勝負がつくまで繰り返す
		while(result.ordinal() <= Result.DRAW.ordinal()) {

			// 前回の結果が「あいこ」の時は処理を変更する
			if (result != Result.DRAW) {
				System.out.println("じゃーんけーん・・・");
			} else {
				System.out.println("あーいこーで・・・");
			}

			System.out.print("出す手を入力 => ");

			// プレイヤーの入力処理
			String input = inputString(bReader);

			// 入力判定
			if (!pattern.matcher(input).matches()) {
				System.out.println("1~3で入力してください。");
				continue;
			}

			// 前回の結果が「あいこ」の場合は処理を変更する
			if (result != Result.DRAW) {
				System.out.println("ぽん！");
			} else {
				System.out.println("しょ！");
			}

			// プレイヤーの入力文字列を数値に変換
			int playerNum = Integer.valueOf(input);

			// コンピュータの入力数値を生成
			int computerNum = random.nextInt(3) + 1;

			// 結果を判定する
			result = Result.values()[(playerNum - computerNum + 3) % 3 + 1];

			// 選択した数値を手に変換する
			Hand playerHand = Hand.values()[playerNum];
			Hand computerHand = Hand.values()[computerNum];

			// 結果表示
			System.out.println("あなた：" + playerHand.toString() + "、コンピュータ：" + computerHand.toString());
			System.out.println(result.toString());
		}
	}


	/**
	 * 入力処理。<br>
	 * 読み込んだ値を返す。
	 * @param bReader BufferedReader
	 * @return 入力文字列
	 */
	private static String inputString(BufferedReader bReader) {
		String input = "";
		try {
			input = bReader.readLine();
		} catch(IOException e) {
			System.out.println("不正な値が入力されました。");
			e.printStackTrace();
			return "";
		}
		return input;
	}
}
