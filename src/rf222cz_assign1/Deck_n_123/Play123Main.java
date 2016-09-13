package rf222cz_assign1.Deck_n_123;

/**
 * Created by ymafr on 2016-09-09.
 */
public class Play123Main {
    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffle();
        int wins = 0;

        //Play 1-2-3 a 1000 times
        for (int i = 0; i <= 1000; i++){
            if(play123(deck))
                wins++;
        }
        float percent = (wins * 100.0f) / 1000;
        System.out.println("Wins: "+wins+"\nChance to win: "+percent+"%");
    }

    public static boolean play123(Deck deck){

        int count = 0;
        while(deck.deckSize() > 0){
            count = (count == 3) ? 1 : count+1;
            Card newCard = deck.handsOutNextCard();
            int index = newCard.rank.ordinal()+1;//Plus one because the ordinal starts with 0
            if( index == 1 && count == 1 ||
                    index == 2 && count == 2 ||
                    index == 3 && count == 3){
                return true;
            }
        }
        return false;
    }
}
