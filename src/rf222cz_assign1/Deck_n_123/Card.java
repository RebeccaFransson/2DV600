package rf222cz_assign1.Deck_n_123;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymafr on 2016-09-08.
 */
public class Card {
    public Suite suite;
    public Rank rank;

    public enum Suite {
        SPADES(1),
        HEARTS(2),
        DIAMONDS(3),
        CLUBS(4);

        //Enum methods so that numbers/index can be mapped to the enum
        private int suite;

        private static Map<Integer, Suite> map = new HashMap<Integer, Suite>();

        static {
            for (Suite suiteEnum : Suite.values()) {
                map.put(suiteEnum.suite, suiteEnum);
            }
        }

        private Suite(final int s) { suite = s; }

        public static Suite valueOf(int s) {
            return map.get(s);
        }
    }
    public enum Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        //Enum methods so that numbersindex can be mapped to the enum
        private int rank;

        private static Map<Integer, Rank> map = new HashMap<Integer, Rank>();

        static {
            for (Rank rankEnum : Rank.values()) {
                map.put(rankEnum.rank, rankEnum);
            }
        }

        private Rank(final int r) { rank = r; }

        public static Rank valueOf(int r) {
            return map.get(r);
        }
    }

    //So that Deck-class can know the length of the Rank and Suite enum
    public int getRankLength(){
        return Rank.values().length;
    }
    public int getSuitesLength(){
        return Suite.values().length;
    }

    //constructor, creates a Card object with the following params
    public Card(int suite, int rank){
        this.suite = Suite.valueOf(suite);
        this.rank = Rank.valueOf(rank);

    }
    //constructor without parameter
    public Card(){

    }
}
