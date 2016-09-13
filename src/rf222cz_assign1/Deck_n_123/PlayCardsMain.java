package rf222cz_assign1.Deck_n_123;

/**
 * Created by ymafr on 2016-09-08.
 */
public class PlayCardsMain {
    public static void main(String[] args){
        System.out.println("Creating deck");
        Deck deck = new Deck();

        System.out.println("Shuffling "+deck.deckSize()+" cards");
        deck.shuffle();

        Card nextCard = deck.handsOutNextCard();
        System.out.println("Next card is "+nextCard.rank +" of "+nextCard.suite);
        nextCard = deck.handsOutNextCard();
        System.out.println("Next card is "+nextCard.rank +" of "+nextCard.suite);
        nextCard = deck.handsOutNextCard();
        System.out.println("Next card is "+nextCard.rank +" of "+nextCard.suite);

        System.out.println("Cards left in deck: "+deck.deckSize());

        System.out.println("Cards that have been dealt: ");
        System.out.println(deck.cardsDealt());

        System.out.println("Try to shuffle again with only "+deck.deckSize()+" in the deck:");
        deck.shuffle();
    }
}
