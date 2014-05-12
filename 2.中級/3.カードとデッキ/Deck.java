package intermediate;

import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * デッキクラス.
 * @author Sujino_Shota
 */
public class Deck {

	/* 山札 */
	private List<Card> cardList = new LinkedList<>();


	/**
	 * コンストラクタ.
	 * ジョーカーの枚数を指定し、対応する枚数分ジョーカーを入れる.
	 * 作った山札は最後にシャッフルする.
	 * @param jokerNum ジョーカーの枚数
	 */
	public Deck(int jokerNum) {
		// 山札を作る
		cardList = makeCardList(jokerNum);
		// カードをシャッフルする
		Collections.shuffle(cardList);
	}


	/**
	 * カードの山札を作る.
	 * @param jokerNum ジョーカーの枚数
	 * @return cards ソートされた山札
	 */
	private List<Card> makeCardList(int jokerNum) {
		List<Card> cards = new LinkedList<>();

		// カードを順番にリストへ入れる
		for (int i = 0; i < EnumSet.allOf(Card.Suit.class).size() - 1; i++) {
			for (int j = 0; j < EnumSet.allOf(Card.Rank.class).size() - 1; j++) {
				cards.add(new Card(Card.Suit.getEnum(i), Card.Rank.getEnum(j)));
			}
		}

		// ジョーカーがある場合は、ジョーカーを入れる
		while (jokerNum > 0) {
			cards.add(new Card(Card.Suit.JOKER));
			jokerNum--;
		}

		return cards;
	}


	/**
	 * 現在の山札の枚数を返す.
	 * @return cardList.size() 山札の残り枚数
	 */
	public int getCardsCount() {
		return cardList.size();
	}


	/**
	 * 山札からカードを引いて、配列で返す.
	 * 残りのカード枚数以上に引こうとすると例外を投げる.
	 * カードを引いた枚数分だけ、先頭から順にカードリストからカードを削除する.
	 * @param drawCount 引きたい枚数
	 */
	public Card[] drawCard(int drawCount) {
		// ドロー枚数がカード枚数を超えている場合は例外を投げる
		if (getCardsCount() < drawCount) {
			throw new IllegalArgumentException();
		}

		Card[] cards = new Card[drawCount];
		// 指定された枚数だけ山札からカードを引く
		for (int i = 0; i < drawCount; i++) {
			cards[i] = cardList.remove(0);
		}
		return cards;
	}

}
