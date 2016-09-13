package rf222cz_assign1.Deck_n_123;

import java.util.*;

/**
 * Created by ymafr on 2016-09-08.
 */
public class Deck {
    int cardLength = 52;
    List<Card> cards = new ArrayList<>();
    List<Card> cardsDealt = new ArrayList<>();

    //Creates 52 cards with all the different suits and ranks
    public Deck(){
        Card c = new Card();
        //Looping for all the suits, and for each rank loop for all the ranks
        for (int x = 1; x < c.getSuitesLength()+1; x++){//plus one because enum starts with one instead of zero
            for (int y = 1; y < c.getRankLength()+1; y++){
                cards.add(new Card(x, y));
            }
        }
    }

    //Shuffles the cards
    public void shuffle(){
        //only when the deck has 52 cards
        if(cards.size() == cardLength){
            Collections.shuffle(cards);
        }else{
            System.err.println("Can only shuffle cards when all of the "+cardLength+" cards in in the deck.");
        }
    }
    //Return the next card and removes it from the list
    public Card handsOutNextCard(){
        Card nextCard = cards.get(0);
        cards.remove(0);
        cardsDealt.add(nextCard);
        return nextCard;
    }

    //Returns the number of cards left in the deck
    public int deckSize(){
        return cards.size();
    }

    //Retuns a string that shows the cards that has been dealt
    public String cardsDealt(){
        String text = "";
        for (int i = 0; i < cardsDealt.size(); i++){
            text += "* "+cardsDealt.get(i).rank +" of "+ cardsDealt.get(i).suite+", \n";
        }
        return text;
    }

}
