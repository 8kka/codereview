package intermediate;

/**
 * トランプのカードクラス.
 * @author Sujino_Shota
 */
public class Card implements Comparable<Card> {

	/**
	 * トランプのスートを表す列挙型クラス.
	 * @author Sujino_Shota
	 */
	public enum Suit {
		CLUBS		("クラブ",		 0),
		DIAMONDS	("ダイヤ",		 1),
		HEARTS		("ハート",		 2),
		SPADES		("スペード",		 3),
		JOKER		("ジョーカー",		-1);

		/** 名前 */
		private final String name;

		/* ID */
		private final int id;

		/* スート配列 */
		private static final Suit[] VALUES = Suit.values();

		/**
		 * コンストラクタ.
		 * @param name スートの名前
		 * @param id スートのID
		 */
		private Suit(String name, int id) {
			this.name = name;
			this.id = id;
		}

		/**
		 * スートの名前を返す.
		 * @return name スートの名前
		 */
		public String Name() { return name; }

		/**
		 * スートのIDを返す.
		 * @return id スートのID
		 */
		public int Id() { return id; }

		/**
		 * ordinal番号で指定されたenumを返す.
		 * @param ordinal Suitのordinal番号
		 * @return VALUES[ordinal] ordinal番号に対応するenum
		 */
		public static Suit getEnum(int ordinal) {
			return VALUES[ordinal];
		}
	}


	/**
	 * トランプのランクを表す列挙型クラス.
	 * @author Sujino_Shota
	 */
	public enum Rank {
		ACE		("Ａ", 	 1),
		DEUCE	("２", 	 2),
		TREY	("３", 	 3),
		CATER	("４", 	 4),
		CINQUE	("５", 	 5),
		SICE	("６", 	 6),
		SEVEN	("７", 	 7),
		EIGHT	("８", 	 8),
		NINE	("９", 	 9),
		TEN		("１０",	10),
		JACK	("Ｊ", 	11),
		QUEEN	("Ｑ", 	12),
		KING	("Ｋ", 	13),
		JOKER	("",	14);

		/* 名前 */
		private final String name;

		/* 番号 */
		private final int num;

		/* ランク配列 */
		private static final Rank[] VALUES = Rank.values();

		/**
		 * コンストラクタ.
		 * @param name ランク名
		 * @param num ランク番号
		 */
		private Rank(String name, int num) {
			this.name = name;
			this.num = num;
		}

		/**
		 * ランクの名前を返す.
		 * @return name ランク名
		 */
		public String Name() { return name; }

		/**
		 * ランクの番号を返す.
		 * @return num ランク番号
		 */
		public int Num() { return num; }

		/**
		 * ordinal番号で指定されたenumを返す.
		 * @param num Rankのordinal番号
		 * @return VALUES[ordinal] ordinal番号に対応するenum
		 */
		public static Rank getEnum(int ordinal) {
			return VALUES[ordinal];
		}
	}


	/* スート属性 */
	private final Suit suit;

	/* ランク属性 */
	private final Rank rank;

	/* カードのソート番号 */
	private int order;


	/**
	 * コンストラクタ.
	 * ジョーカー以外のカードを指定する場合.
	 * @param suit スート属性
	 * @param rank ランク属性
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		order = suit.Id() * 13 + rank.Num();
	}


	/**
	 * コンストラクタ.
	 * ジョーカーを指定する場合.
	 * ソート番号はint型の最大値を取る
	 * @param joker スート属性のジョーカー
	 */
	public Card(Suit joker) {
		this.suit = Suit.JOKER;
		this.rank = Rank.JOKER;
		order = Integer.MAX_VALUE;
	}


	/**
	 * スート属性を返す.
	 * @return suit スート属性
	 */
	public Suit Suit() { return suit; }


	/**
	 * ランク属性を返す.
	 * @return rank ランク属性
	 */
	public Rank Rank() { return rank; }


	/**
	 * ソート番号を返す.
	 * @return order ソート番号
	 */
	public int Order() { return order; }


	/**
	 * ソート用の比較関数.
	 * 自分のorderの方が大きければ「1」を返す.
	 * 自分のorderの方が小さければ「-1」を返す.
	 * 自分のorderと同じならば「0」を返す.
	 * @param Card 比較対象のカード
	 * @return 比較結果の数値
	 */
	@Override
	public int compareTo(Card card) {
		int compareNum = this.order - card.order;
		if (compareNum > 0) {
			return 1;
		} else if (compareNum < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}
