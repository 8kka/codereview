package intermediate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import intermediate.Card.Suit;
import intermediate.Card.Rank;

import org.junit.Test;

public class CardTest {

	@Test
	public void クラブよりダイヤの方が大きい() {
		Card club1 = new Card(Suit.CLUBS, Rank.ACE);
		Card diamond1 = new Card(Suit.DIAMONDS, Rank.ACE);

		int actual = club1.compareTo(diamond1);

		assertThat(actual, is(-1));
	}

	@Test
	public void ダイヤよりハートの方が大きい() {
		Card diamond1 = new Card(Suit.DIAMONDS, Rank.ACE);
		Card heart1 = new Card(Suit.HEARTS, Rank.ACE);

		int actual = diamond1.compareTo(heart1);

		assertThat(actual, is(-1));
	}

	@Test
	public void ハートよりスペードの方が大きい() {
		Card heart1 = new Card(Suit.HEARTS, Rank.ACE);
		Card spade1 = new Card(Suit.SPADES, Rank.ACE);

		int actual = heart1.compareTo(spade1);

		assertThat(actual, is(-1));
	}

	@Test
	public void スペードよりジョーカーの方が大きい() {
		Card spade1 = new Card(Suit.SPADES, Rank.ACE);
		Card joker = new Card(Suit.JOKER);

		int actual = spade1.compareTo(joker);

		assertThat(actual, is(-1));
	}

}
