import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * じゃんけんをするクラス.
 * じゃんけんの手に対応する数値を入力して、コンピュータと対戦する.
 *
 * @author Shota Sujino
 */
public class RPS_v1 {

	/**
	 * メイン処理.
	 * @param args
	 */
	public static void main(String[] args) {

		// ゲーム説明
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー");
		System.out.println("じゃーんけーん・・・");
		System.out.print("出す手を入力 => ");

		// 入力処理
		String input = inputString();
		
		// 入力値判定
		if (!isCorrectInput(input)) {

			System.out.println("1~3で入力してください。");

		} else {

			// 数値変換
			int playerNum = Integer.valueOf(input);

			// コンピュータの数値選択
			int computerNum = makeComNumber();

			// 結果を解析
			String result = checkResult(playerNum, computerNum);

			// 数値を文字列に変換
			String playerHand = numToHandName(playerNum);
			String computerHand = numToHandName(computerNum);

			// ゲーム結果
			System.out.println("ぽん！");
			System.out.println("あなた：" + playerHand + "、コンピュータ：" + computerHand);
			System.out.println(result);

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
	 * 入力値判定.
	 * 入力された値が1,2,3のいずれかであるかを調べる.
	 * @param input 入力文字列
	 * @return ture or false
	 */
	private static boolean isCorrectInput(String input) {
		Pattern pattern = Pattern.compile("[123]");
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * コンピュータの回答数値を乱数で生成.
	 * @return computerNum コンピュータの選んだ数値
	 */
	private static int makeComNumber() {
		Random random = new Random();
        int computerNum = random.nextInt(3) + 1;

        return computerNum;
	}


	/**
	 * 勝負の結果を調べる.
	 * @playerNum プレイヤーの選んだ数字
	 * @computerNum コンピュータの選んだ数字
	 * @result 勝負の結果
	 */
	private static String checkResult(int playerNum, int computerNum) {
		String result = "";
		// 勝負の判定をする計算式
		int checkNum = (playerNum - computerNum + 3) % 3;
		switch (checkNum) {
			case 1: result = "あなたの負けです！"; break;
			case 2: result = "あなたの勝ちです！"; break;
			default: result = "あいこでした！"; break;
		}

		return result;
	}


	/**
	 * 数値を手の種類に変換する.
	 * @number 選んだ数字
	 */
	private static String numToHandName(int number) {
		String handName = "";
		switch (number) {
			case 1: handName = "グー"; break;
			case 2: handName = "チョキ"; break;
			case 3: handName = "パー"; break;
		}
		return handName;
	}
}