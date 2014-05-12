package intermediate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DeckTest {

	@Test
	public void デッキは52枚の基本カードを保持する() {
		int jokerNum = 0;
		Deck deck = new Deck(jokerNum);

		int actual = deck.getCardsCount();

		assertThat(actual, is(52));
	}

	@Test
	public void drawCardは指定枚数分のカードをデッキから取得する() {
		int jokerNum = 2;
		Deck deck = new Deck(jokerNum);

		int drawCardNum = 5;
		Card[] cards = deck.drawCard(drawCardNum);

		int actual = cards.length;
		int matcher = drawCardNum;

		assertThat(actual, is(matcher));
	}

	@Test
	public void getCardsCountは現在のデッキ内のカード枚数を返す() {
		int jokerNum = 2;
		Deck deck = new Deck(jokerNum);

		int drawCardNum = 4;
		deck.drawCard(drawCardNum);

		int actual = deck.getCardsCount();
		int matcher = 52 + 2 - drawCardNum;

		assertThat(actual, is(matcher));
	}

	@Test(expected=IllegalArgumentException.class)
	public void 残り枚数より多くカードを引こうとするとIllegalArgumentExceptionを返す() {
		int jokerNum = 0;
		Deck deck = new Deck(jokerNum);

		deck.drawCard(53);
	}

}
