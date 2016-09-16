package rf222cz_assign2.Exercise5_CountWords;

/**
 * Created by ymafr on 2016-09-16.
 */
public class Word implements Comparable<Word>{

    private String word;

    public Word(String str) {
        //...
    }
    public String toString() {
        return word;
    }
    @Override
    public int hashCode() {
        //"compute a hash value for word"
    }

    @Override
    public boolean equals(Object other) {
        //"true if two words are equal"
        return this.word.equals(other);
    }
/** returns < 0 then the String calling the method is lexicographically first (comes first in a dictionary)
    returns == 0 then the two strings are lexicographically equivalent
    returns > 0 then the parameter passed to the compareTo method is lexicographically first.*/
    @Override
    public int compareTo(Word w) {
        //"compares two words lexicographically"
        return this.word.toString().compareTo(w.toString());
    }
}
