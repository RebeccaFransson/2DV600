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
        /*int hash = 0;
        for (char c : this.word.toCharArray()){
            hash += (int)c;
        }
        return hash;*/
        //Föreläsaren tyckte man skulle använda javas biblotek
        return this.word.hashCode();
    }

    @Override
    //TODO: need to be same instance?
    public boolean equals(Object other) {
        //"true if two words are equal"
        //Both returns works
        //return this.word.toLowerCase().equals(other.toString().toLowerCase());
        if (other instanceof Word) {
            Word w = (Word) other;
            String str = w.toString();
            if (str.length() == this.word.length()) {
                for (int i=0;i<str.length();i++) {
                    if (str.charAt(i) != this.word.charAt(i))
                        return false;
                }
                return true;
            }
        }
        return false;
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
