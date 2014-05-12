package intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * 重複を削除するクラス.
 *
 * @author Sujino_Shota
 *
 */
public class Intermediate2 {

	/**
	 * 重複を削除する.
	 * 与えられた配列内の前後が同じ数字を削除する.
	 * １度出現した値でも、連続で格納されていなければ削除しない.
	 * @param src 対象の数値配列
	 * @return uniqArray 重複を削除した配列
	 */
	public static int[] uniq(int[] src) {

		// 重複していないリストを作成する
		List<Integer> uniqList = new ArrayList<>();
		for (int i = 0; i < src.length; i++) {
			if (i > 0 && src[i] == src[i - 1]) {
				continue;
			} else {
				uniqList.add(src[i]);
			}
		}

		// リストを配列に変換する
		int[] uniqArray = new int[uniqList.size()];
		for (int i = 0; i < uniqList.size(); i++) {
			uniqArray[i] = uniqList.get(i);
		}

		return uniqArray;
	}

}
