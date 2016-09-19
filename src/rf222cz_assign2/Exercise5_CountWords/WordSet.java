package rf222cz_assign2.Exercise5_CountWords;

/**
 * Created by ymafr on 2016-09-16.
 */
public interface WordSet extends Iterable {
    void add(Word w); // Add word if not already added
    boolean contains(Word w); // Return true if word contained
    int size(); // Return current set size
    String toString(); // Print contained words
}
