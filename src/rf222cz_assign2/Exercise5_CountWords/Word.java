package rf222cz_assign2.Exercise5_CountWords;

/**
 * Created by ymafr on 2016-09-16.
 */
public class Word implements Comparable<Word>{

    private String word;

    public Word(String str) {
        this.word = str;
    }
    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char c : this.word.toCharArray()){
            hash += (int)c;
        }
        return hash;
    }

    @Override
    //TODO: need to be same instance?
    public boolean equals(Object other) {
        //"true if two words are equal"
        return this.word.toLowerCase().equals(other.toString().toLowerCase());
    }
/** returns < 0 then the String calling the method is lexicographically first (comes first in a dictionary)
    returns == 0 then the two strings are lexicographically equivalent
    returns > 0 then the parameter passed to the compareTo method is lexicographically first.*/
    @Override
    public int compareTo(Word w) {
        //"compares two words lexicographically"
        return this.word.compareToIgnoreCase(w.toString());
    }
}
